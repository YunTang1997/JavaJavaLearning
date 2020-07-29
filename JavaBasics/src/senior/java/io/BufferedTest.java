package senior.java.io;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.Buffer;

/**
 * 处理流之一：缓冲流的使用
 *
 * 1.缓冲流：
 *   BufferedInputStream
 *   BufferedOutputStream
 *   BufferedReader
 *   BufferedWriter
 *
 * 2.作用：提供流的读取、写入的速度
 *   提高读写速度的原因：内部提供了一个缓冲区
 *
 * 3.处理流，就是“套接”在已有的流的基础上。
 * @author YunTang
 * @create 2020-07-29 9:16
 */

public class BufferedTest {

    @Test
    public void BufferedStreamTest(){

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File srcFile = new File("dream.jpg");
            File desFile = new File("dream1.jpg");

            // 造节点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(desFile);

            // 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            byte[] buffer = new byte[10];
            int len;
            while((len = bis.read(buffer)) != -1){
                bos.write(buffer, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 资源关闭
            // 要求：先关闭外层的流，再关闭内层的流
            // 说明：关闭外层流的同时，内层流也会自动的进行关闭。关于内层流的关闭，我们可以省略.
            try {
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 实现文件复制的方法
    @Test
    public void copyFileWithBuffered(String srcPath, String desPath){

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            File srcFile = new File(srcPath);
            File desFile = new File(desPath);

            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(desFile);

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            byte[] buffer = new byte[1024];
            int len;
            while((len = bis.read(buffer)) != -1){
                bos.write(buffer, 0, len);

//                bos.flush(); // 刷新缓冲区
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 利用缓冲流拷贝文件
     */
    @Test
    public void testCopyFileWithBuffered() {

        long start = System.currentTimeMillis();

        String srcFile = "D:\\Desktop\\test.3gp";
        String desFile = "D:\\Desktop\\test1.3gp";

        copyFileWithBuffered(srcFile, desFile);

        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }

    /**
     * 使用BufferedReader和BufferedWriter实现文本文件的复制
     */
    @Test
    public void testBufferedReaderBufferedWriter(){

        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            // 创建文件和相应的流
            br = new BufferedReader(new FileReader(new File("dbcp.txt")));
            bw = new BufferedWriter(new FileWriter(new File("dbcp1.txt")));

            // 读写操作
            // 方式一：使用char[]数组
//            char[] cbuf = new char[1024];
//            int len;
//            while((len = br.read(cbuf)) != -1){
//                bw.write(cbuf,0,len);
//    //            bw.flush();
//            }

            // 方式二：使用String
            String data;
            while((data = br.readLine()) != null){
                //方法一：
//                bw.write(data + "\n"); // data中不包含换行符
                //方法二：
                bw.write(data); // data中不包含换行符
                bw.newLine(); // 提供换行的操作
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if(bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }
}
