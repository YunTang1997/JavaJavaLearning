package senior.java.thread;

import java.util.concurrent.locks.ReentrantLock; // 控制多个线程对共享资源进行访问的工具

/**
 * 解决线程安全问题的方式三：Lock锁  --- JDK5.0新增
 *
 * 1. 面试题：synchronized 与 Lock的异同？
 *   相同：二者都可以解决线程安全问题
 *   不同：synchronized机制在执行完相应的同步代码以后，[自动的]释放同步监视器
 *         Lock需要[手动的]启动同步（lock()），同时结束同步也需要[手动的]实现（unlock()）
 *
 * 2.优先使用顺序：
 * Lock  同步代码块（已经进入了方法体，分配了相应资源）  同步方法（在方法体之外）
 *
 * 面试题：如何解决线程安全问题？有几种方式
 *
 * @author YunTang
 * @create 2020-07-26 20:01
 */

public class LockTest {

    public static void main(String[] args) {

        Window6 window6 = new Window6();

        Thread thread1 = new Thread(window6);
        Thread thread2 = new Thread(window6);
        Thread thread3 = new Thread(window6);

        thread1.setName("窗口一");
        thread1.start();

        thread2.setName("窗口二");
        thread2.start();

        thread3.setName("窗口三");
        thread3.start();

    }

}

class Window6 implements Runnable{

    private int ticket = 100;
    // 1.实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {

        while(true){

            try {

                // 2.调用锁定方法lock()
                lock.lock();

                if (ticket > 0){

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "，出售车票：" + ticket);
                    ticket--;
                }
                else{
                    break;
                }
            } finally {

                //3.调用解锁方法：unlock()
                lock.unlock();
            }
        }
    }
}
