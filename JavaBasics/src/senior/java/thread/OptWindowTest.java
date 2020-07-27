package senior.java.thread;


/**
 * 使用同步代码块解决继承Thread类的方式的线程安全问题
 *
 * 例子：创建三个窗口卖票，总票数为100张.使用继承Thread类的方式
 *
 * 说明：在继承Thread类创建多线程的方式中，[慎用]this充当同步监视器，考虑使用[当前类]充当同步监视器。
 * @author YunTang
 * @create 2020-07-26 16:19
 */

public class OptWindowTest {

    public static void main(String[] args) {

        Window3 window1 = new Window3();
        Window3 window2 = new Window3();
        Window3 window3 = new Window3();

        window1.setName("线程一");
        window2.setName("线程二");
        window3.setName("线程三");

        window1.start();
        window2.start();
        window3.start();
    }

}

class Window3 extends Thread{

    private static int tickets = 100; // 注意用static修饰
//    private static Object obj = new Object(); // 注意用static修饰

    @Override
    public void run() {

        while(true){
            synchronized (Window3.class) { //Class clazz = Window3.class，Window3.class只会加载一次；
                // 方式二：synchronized (obj)（错误的方式：this代表着window1,window2,window3三个对象）
                if (tickets > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "：买票，票号为：" + tickets);
                    tickets--;
                } else {
                    break;
                }
            }
        }
    }
}
