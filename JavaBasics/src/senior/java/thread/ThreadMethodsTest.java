package senior.java.thread;

/**
 * @author YunTang
 * @create 2020-07-25 21:51
 */

/**
 * 测试Thread中的常用方法：
 * 1. start():启动当前线程；调用当前线程的run()
 *
 * 2. run(): 通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中
 *
 * 3. currentThread():静态方法，返回执行当前代码的线程
 *
 * 4. getName():获取当前线程的名字
 *
 * 5. setName():设置当前线程的名字
 *
 * 6. yield():释放当前cpu的执行权
 *
 * 7. join():在线程a中调用线程b的join(),此时线程a就进入阻塞状态，直到线程b完全执行完以后，线程a才结束阻塞状态
 *
 * 8. stop():已过时。当执行此方法时，强制结束当前线程
 *
 * 9. sleep(long millitime):让当前线程“睡眠”指定的millitime毫秒。在指定的millitime毫秒时间内，当前线程是阻塞状态
 *
 * 10. isAlive():判断当前线程是否存活
 *
 *
 * 线程的优先级：
 * 1.
 * MAX_PRIORITY：10
 * MIN _PRIORITY：1
 * NORM_PRIORITY：5  -->默认优先级
 *
 * 2.如何获取和设置当前线程的优先级：
 *   getPriority():获取线程的优先级
 *   setPriority(int p):设置线程的优先级
 *
 * 说明：高优先级的线程要抢占低优先级线程cpu的执行权。但是只是从概率上讲，高优先级的线程高概率的情况下
 * 被执行。并不意味着只有当高优先级的线程执行完以后，低优先级的线程才执行。
 */

public class ThreadMethodsTest {

    public static void main(String[] args) {

        HelloThread helloThread = new HelloThread();

        helloThread.setName("线程一");
        helloThread.start();

        // 给主线程命名
        Thread.currentThread().setName("主线程");

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }


    }
}

class HelloThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }

            if (i % 20 == 0){
                yield();
            }
        }
    }

    // 也可以通过定义带参构造器，利用super调用父类Thread中的带参构造器，给线程命名
//    public HelloThread(String name){
//        super(name);
//    }
}
