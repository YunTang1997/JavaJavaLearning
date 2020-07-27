package senior.java.thread;

/**
 * 线程通信的例子：使用两个线程打印 1-100。线程1, 线程2 交替打印
 *
 * 涉及到的三个方法：
 * wait():一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器。
 *
 * notify():一旦执行此方法，就会唤醒被wait的一个线程。如果有多个线程被wait，就唤醒优先级高的那个。
 *
 * notifyAll():一旦执行此方法，就会唤醒所有被wait的线程。
 *
 * 说明：
 * 1.wait()，notify()，notifyAll()三个方法[必须]使用在[同步代码块]或[同步方法]中。
 *
 * 2.wait()，notify()，notifyAll()三个方法的调用者必须是同步代码块或同步方法中的[同步监视器]。
 *   否则，会出现IllegalMonitorStateException异常
 *
 * 3.wait()，notify()，notifyAll()三个方法是定义在[java.lang.Object]类中，以保证[任何一个对象]做同步监视器都能调用这三个方法。
 *
 * 面试题：sleep()和wait()的异同？
 * 1.相同点：一旦执行方法，都可以使得当前的线程进入阻塞状态。
 *
 * 2.不同点：①两个方法声明的位置不同：Thread类中声明sleep(), Object类中声明wait()
 *          ②调用的要求不同：sleep()可以在任何需要的场景下调用。 wait()必须使用在同步代码块或同步方法中
 *          ③关于是否释放同步监视器：如果两个方法都使用在同步代码块或同步方法中，sleep()不会释放锁，wait()会释放锁。
 *
 * @author YunTang
 * @create 2020-07-27 16:48
 */

public class CommunicationTest {

    public static void main(String[] args) {

        Number number = new Number();
        Thread thread1 = new Thread(number);
        Thread thread2 = new Thread(number);

        thread1.setName("线程一");
        thread1.start();

        thread2.setName("线程二");
        thread2.start();
    }

}

class Number implements Runnable{

    private int number = 1;

    @Override
    public void run() {

        while(true){

            synchronized (this) {

                notify(); // 释放处于阻塞状态的线程

                if (number <= 100) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;

                    try {
                        // 使得调用如下wait()方法的线程进入阻塞状态，且释放锁
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    break;
                }
            }
        }
    }
}


