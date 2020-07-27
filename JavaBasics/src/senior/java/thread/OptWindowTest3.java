package senior.java.thread;

/**
 * 使用同步方法解决实现Runnable接口的线程安全问题
 *
 * 关于同步方法的总结：
 *   1.同步方法仍然涉及到同步监视器，只是不需要我们显式的声明。
 *   2.非静态的同步方法，同步监视器是：this
 *   3.静态的同步方法，同步监视器是：当前类本身
 * @author YunTang
 * @create 2020-07-26 17:14
 */

public class OptWindowTest3 {

    public static void main(String[] args) {

        Window5 window1 = new Window5();

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

class Window5 implements Runnable{

    private int tickets = 100;

    @Override
    public void run() {
        while(true) {
            show();
        }
    }

    public synchronized void show(){ // 同步监视器：this

        if (tickets > 0){

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "：买票，票号为：" + tickets);
            tickets--;
        }

    }
}
