package start.java;

import javax.xml.bind.SchemaOutputResolver;
import java.awt.peer.PanelPeer;

/**
 * @author YunTang
 * @create 2020-07-19 19:03
 */

/*
接口的使用：
    ①接口的使用也满足多态性
    ②接口，实际上就是定义了一种规范
    ③开发中，体会面向接口编程
 */
public class USBTest {

    public static void main(String[] args) {

        Computer computer = new Computer();
        // 1.创建了接口的非匿名实现类的非匿名对象
        Flash flash = new Flash();
        computer.transferDate(flash);

        // 2.创建了接口的非匿名实现类的匿名对象
        computer.transferDate(new Printer());

        // 3.创建了接口的匿名实现类的非匿名对象
        USB phone = new USB(){

            @Override
            public void start() {
                System.out.println("手机开始工作");
            }

            @Override
            public void stop() {
                System.out.println("手机结束工作");
            }
        };

        computer.transferDate(phone);

        // 4.创建了接口的匿名实现类的匿名对象
        computer.transferDate(new USB() {
            @Override
            public void start() {
                System.out.println("mp3开始工作");
            }

            @Override
            public void stop() {
                System.out.println("mp3停止工作");
            }
        });
    }
}


class Computer{

    public void transferDate(USB usb){ // 多态的体现 USB usb = new Flash
        usb.start();

        System.out.println("具体传输数据的细节");

        usb.stop();
    }
}


interface USB{
    // 常量定义了长、款、最大最小的传输速度等
    public abstract void start();

    public abstract void stop();
}


class Flash implements USB{

    @Override
    public void start() {
        System.out.println("U盘开启工作");
    }

    @Override
    public void stop() {
        System.out.println("U盘结束工作");
    }
}


class Printer implements USB{

    @Override
    public void start() {
        System.out.println("打印机开启工作");
    }

    @Override
    public void stop() {
        System.out.println("打印机结束工作");
    }
}
