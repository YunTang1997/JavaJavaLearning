package senior.java.thread;

/**
 * 使用同步方法处理继承Thread类的方式中的线程安全问题
 *
 *关于同步方法的总结：
 *  1.同步方法仍然涉及到同步监视器，只是不需要我们显式的声明。
 *  2.静态的同步方法，同步监视器是：当前类本身
 * @author YunTang
 * @create 2020-07-26 16:48
 */
public class OptWindowTest2 {

    public static void main(String[] args) {

        Window4 window1 = new Window4();
        Window4 window2 = new Window4();
        Window4 window3 = new Window4();

        window1.setName("线程一");
        window2.setName("线程二");
        window3.setName("线程三");

        window1.start();
        window2.start();
        window3.start();

    }
}

class Window4 extends Thread{

    private static int tickets = 100;

    @Override
    public void run() {
        while (true) {
            show();
        }
    }

    public static synchronized void show(){ // 注意要用static修饰，同步监视器：Window4.class

        if (tickets > 0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "：买票，票号为："  + tickets);
            tickets--;
        }
    }
}
