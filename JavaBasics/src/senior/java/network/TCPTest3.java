package senior.java.network;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import jdk.nashorn.internal.ir.CatchNode;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 3.从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给客户端。并关闭相应的连接。
 * @author YunTang
 * @create 2020-07-30 21:34
 */
public class TCPTest3 {

    // 客户端
    @Test
    public void client(){

        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 8899);

            os = socket.getOutputStream();

            fis = new FileInputStream(new File("dream.jpg"));

            byte[] buffer = new byte[1024];
            int len;
            while((len = fis.read(buffer)) != -1){
                os.write(buffer, 0, len);
            }

            // 关闭数据输出（如果不关闭，服务端的反馈部分代码将无法运行，服务端的执行会一直停留在服务端的while循环）
            socket.shutdownOutput();

            // 客户端接受服务端的反馈
            is = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] bufferr = new byte[5];
            int lent;
            while((lent = is.read(bufferr)) != -1){
                baos.write(bufferr, 0, lent);
            }
            System.out.println(baos.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
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
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (baos != null){
                    baos.close();
                }
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }

    }

    // 服务端
    @Test
    public void server(){

        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        FileOutputStream fos = null;
        OutputStream os = null;
        try {
            ss = new ServerSocket(8899);

            socket = ss.accept();

            is = socket.getInputStream();

            fos = new FileOutputStream(new File("dream5.jpg"));

            byte[] buffer = new byte[1024];
            int len;
            while((len = is.read(buffer)) != -1){
                fos.write(buffer, 0, len);
            }

            // 服务端给客户端的反馈
            os = socket.getOutputStream();
            os.write("你好！已收到你传的图片".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
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
                if (ss != null)
                    ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (os != null){
                    os.close();
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
