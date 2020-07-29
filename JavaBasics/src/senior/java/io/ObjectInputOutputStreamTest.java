package senior.java.io;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 对象流的使用
 * 1.ObjectInputStream和ObjectOutputStream
 * 2.作用：用于存储和读取基本数据类型数据或对象的处理流。它的强大之处就是可以把Java中的对象写入到数据源中，也能把对象从数据源中还原回来。
 *
 * 3.要想一个java对象是可序列化的，需要满足相应的要求。见Person.java
 *
 * 4.序列化机制：
 *   对象序列化机制允许把内存中的Java对象转换成平台无关的二进制流，从而允许把这种
 *   二进制流持久地保存在磁盘上，或通过网络将这种二进制流传输到另一个网络节点。
 *   当其它程序获取了这种二进制流，就可以恢复成原来的Java对象。
 * @author YunTang
 * @create 2020-07-29 18:44
 */

public class ObjectInputOutputStreamTest {

    /*
    序列化过程：将内存中的java对象保存到磁盘中或通过网络传输出去，使用ObjectOutputStream
     */
    @Test
    public void testObjectOutputStream(){

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));

            oos.writeObject(new String("我爱成都"));
            oos.flush();

            oos.writeObject(new Person("ty",23));
            oos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null)
                    oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    反序列化过程：将将磁盘文件中的对象还原为内存中的一个java对象，使用ObjectInputStream来实现
     */
    @Test
    public void testPbjectInputStream(){

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));

            Object obj = ois.readObject();
            String str = (String) obj;
            Person p = (Person) ois.readObject();

            // 按写入顺序输出
            System.out.println(str);
            System.out.println(p);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null)
                    ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
