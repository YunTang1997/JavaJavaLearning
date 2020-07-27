package senior.java.thread;


/**
 * @author YunTang
 * @create 2020-07-26 11:30
 */

/*
例子：创建三个窗口卖票，总票数为100张.使用实现Runnable接口的方式
存在线程的安全问题，待解决。
 */
public class WindowTest1 {

    public static void main(String[] args) {

        Window1 window1 = new Window1();

        Thread thread = new Thread(window1);
        thread.setName("窗口一");
        thread.start();

        Thread thread1 = new Thread(window1);
        thread1.setName("窗口二");
        thread1.start();

        Thread thread2 = new Thread(window1);
        thread2.setName("窗口三");
        thread2.start();

    }
}

class Window1 implements Runnable{

    private int tickets = 100;

    @Override
    public void run() {

        while (true){
            if (tickets > 0){

                System.out.println(Thread.currentThread().getName() + "：买票，票号为：" + tickets);
                tickets--;
            }
            else{
                break;
            }
        }
    }
}
