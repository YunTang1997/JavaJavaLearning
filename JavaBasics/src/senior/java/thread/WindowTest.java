package senior.java.thread;

/**
 * @author YunTang
 * @create 2020-07-26 10:44
 */

/*
例子：创建三个窗口卖票，总票数为100张。使用继承Thread类的方式
存在线程的安全问题，需要解决。
 */

public class WindowTest {

    public static void main(String[] args) {

        Window window1 = new Window();
        Window window2 = new Window();
        Window window3 = new Window();

        window1.setName("线程一");
        window2.setName("线程二");
        window3.setName("线程三");

        window1.start();
        window2.start();
        window3.start();

    }
}

class Window extends Thread{

    private static int tickets = 100;

    @Override
    public void run() {

        while(true){
            if (tickets > 0){

                System.out.println(Thread.currentThread().getName() + "：买票，票号为："  + tickets);
                tickets--;
            }
            else{
                break;
            }
        }
    }
}