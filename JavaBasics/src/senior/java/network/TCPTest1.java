package senior.java.network;

import jdk.internal.org.objectweb.asm.TypeReference;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1.客户端发送内容给服务端，服务端将内容打印到控制台上
 * @author YunTang
 * @create 2020-07-30 20:18
 */
public class TCPTest1 {

    // 客户端（后启动）
    @Test
    public void client(){

        Socket socket = null;
        OutputStream os = null;
        try {
            // 1.创建Socket对象，指明服务器端的ip和端口号
            InetAddress address = InetAddress.getByName("127.0.0.1");
            socket = new Socket(address, 8899);

            // 2.获取一个输出流，用于输出数据
            os = socket.getOutputStream();

            // 3.写出数据操作
            os.write("你好，我是客户端！".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        // 4.关闭资源
        } finally {
            try {
                if (os != null)
                    os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 服务端（先启动）
    @Test
    public void server(){

        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            // 1.创建ServerSocket，指明自己的端口号（IP不需要指定，在那个主机上运行的，IP就确定了）
            ss = new ServerSocket(8899);

            // 2.调用accpet()表示接收来自客户端的Socket
            socket = ss.accept();

            // 3.获取输入流
            is = socket.getInputStream();

            /*防止中文出现乱码，使用ByteArrayOutputStream()，将数据写入其内置数组中*/
            // 4.读取输入流的数据
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];
            int len;
            while((len = is.read(buffer)) != -1){
                baos.write(buffer, 0, len);
            }
            System.out.println(baos.toString());
            System.out.println("收到来自于：" + socket.getInetAddress().getHostAddress() + "的信息！");

        } catch (IOException e) {
            e.printStackTrace();
        // 5.资源的关闭
        } finally {
            try {
                if (baos != null){
                    baos.close();
                }
            }
            catch(IOException e){
                e.printStackTrace();
            }
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(ss != null){
                    ss.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
