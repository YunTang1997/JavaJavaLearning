package senior.java.io;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 一、流的分类：
 * 1.操作数据单位：字节流、字符流
 * 2.数据的流向：输入流、输出流
 * 3.流的角色：节点流、处理流
 *
 * 二、流的体系结构
 * 抽象基类         节点流（或文件流）                               缓冲流（处理流的一种）
 * InputStream     FileInputStream   (read(byte[] buffer))        BufferedInputStream (read(byte[] buffer))
 * OutputStream    FileOutputStream  (write(byte[] buffer,0,len)  BufferedOutputStream (write(byte[] buffer,0,len) / flush()
 * Reader          FileReader (read(char[] cbuf))                 BufferedReader (read(char[] cbuf) / readLine())
 * Writer          FileWriter (write(char[] cbuf,0,len)           BufferedWriter (write(char[] cbuf,0,len) / flush()
 * @author YunTang
 * @create 2020-07-28 19:37
 */

public class FileReaderWriterTest {

    /**
     * 将io下的hello.txt文件内容读入程序中，并输出到控制台
     */
    @Test
    public void test1(){

        FileReader fileReader = null;

        // 异常的处理：为了保证流资源[一定]可以执行关闭操作。需要使用try-catch-finally处理
        try {
            // 1.实例化File类的对象，知名要操作的文件
            // test模块中是相对于module的相对路径，而main()方法中相对于project的相对路径
            File file = new File("hello.txt"); // 读入的文件一定要存在，否则就会报FileNotFoundException

            // 2.提供具体的流
            fileReader = new FileReader(file);

            // 3.数据的读入
            // read()：返回读入的一个字符。如果达到文件末尾，返回-1
            // 方式一：
//        int data = fileReader.read();
//        while(data != -1){
//            System.out.print((char)data);
//            data = fileReader.read();
//        }

            // 方式二：
            int data;
            while ((data = fileReader.read()) != -1){
                System.out.print((char)data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4.流的关闭
            try {
                if (fileReader != null)
                    fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 对read()操作升级：使用read的重载方法
    @Test
    public void test2(){

        FileReader fileReader = null;
        try {
            // 1.File类的实例话
            File file = new File("hello.txt");

            // 2.流的而实例化
            fileReader = new FileReader(file);

            // 3.读入操作（实质是给定长度为5的char型数组，每次读取5位，第二次读取开始，读取的字符按序[覆盖]原有的字符）
            char[] cbuf = new char[5];
            int len;
            while((len = fileReader.read(cbuf)) != -1){
                //方式一：
                //错误的写法
//                for(int i = 0;i < cbuf.length;i++){
//                    System.out.print(cbuf[i]);
//                }
                // 正确的写法
//                for (int i = 0; i < len; i++) {
//                    System.out.print(cbuf[i]);
//                }

                // 方式二
                // 错误的写法
//                String str = new String(cbuf);
//                System.out.print(str);

                // 正确的写法
                String str = new String(cbuf, 0, len);
                System.out.print(str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 资源的关闭
            try {
                if (fileReader != null)
                    fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 从内存中写出数据到硬盘的文件里。
     *
     * 说明：
     *     1.输出操作，对应的File可以不存在的。并不会报异常。
     *     2.File对应的硬盘中的文件如果[不存在]，在输出的过程中，会[自动创建]此文件。
     *       File对应的硬盘中的文件如果[存在]：
     *           如果流使用的构造器是：FileWriter(file,false) / FileWriter(file)：对原有文件的覆盖。
     *           如果流使用的构造器是：FileWriter(file,true)：不会对原有文件覆盖，而是在原有文件基础上追加内容。
     */
    @Test
    public void test3(){

        FileWriter fileWriter = null;
        try {
            // 1.提供File类的对象，指明写出到的文件
            File file = new File("hello1.txt");

            // 2.提供FileWriter的对象，用于数据的写出
            fileWriter = new FileWriter(file);

            // 3.写出操作
            fileWriter.write("I have a dream!\n");
            fileWriter.write("You need to have a dream.\n");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4.流资源的关闭
            try {
                if (fileWriter != null)
                    fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 文件的复制
    @Test
    public void testFileReaderFileWriter(){

        // 1.创建File类的对象，指明读入和写出的文件
        File srcFile = new File("hello.txt");
        File desFile = new File("Hello2.txt");

        // 2.创建输入流和输出流的对象
        FileReader fileReader = null;
        FileWriter fileWriter = null;

        try {
            fileReader = new FileReader(srcFile);
            fileWriter = new FileWriter(desFile);

            // 3.数据的读入和写出
            char[] cbuf = new char[5];
            int len;
            while((len = fileReader.read(cbuf)) != -1){
                fileWriter.write(cbuf, 0, len);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            // 4.关闭资源
            // 方式一：
            try {
                if (fileWriter != null)
                    fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(fileReader != null)
                    fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // 方式二：
//            try {
//                if (fileWriter != null)
//                    fileWriter.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            finally {
//                try {
//                    if(fileReader != null)
//                        fileReader.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }
}
