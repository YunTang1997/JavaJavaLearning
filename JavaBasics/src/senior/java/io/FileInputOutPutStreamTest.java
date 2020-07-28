package senior.java.io;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 测试FileInputStream和FileOutputStream的使用
 *
 * 结论：
 * 1.对于文本文件(.txt,.java,.c,.cpp)，使用[字符流]处理。
 * 2.对于非文本文件(.jpg,.mp3,.mp4,.avi,.doc,.ppt,...)，使用[字节流]处理。
 * @author YunTang
 * @create 2020-07-28 21:51
 */

public class FileInputOutPutStreamTest {

    // 图片（或视频）的复制（字节流，不能使用字符流会损坏文件）
    @Test
    public void testPictureReaderPictureWriter(){

        // 1.创建File类的对象，指明读入和写出的文件
        File srcFile = new File("dream.jpg");
        File desFile = new File("dream1.jpg");

        // 2.创建输入流和输出流的对象
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {

            fileInputStream = new FileInputStream(srcFile);
            fileOutputStream = new FileOutputStream(desFile);

            // 3.数据的读入和写出
            byte[] cbuf = new byte[5];
            int len;
            while((len = fileInputStream.read(cbuf)) != -1){
                fileOutputStream.write(cbuf, 0, len);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            // 4.关闭资源
            // 方式一：
            try {
                if (fileOutputStream != null)
                    fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(fileInputStream != null)
                    fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
