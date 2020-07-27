package senior.java.thread;

/**
 * 使用同步机制将单例模式中的懒汉式改写为线程安全的
 * @author YunTang
 * @create 2020-07-26 19:16
 */

public class BankTest {
}

class Bank{

    private Bank(){

    }

    private static Bank instance = null;

//    public static synchronized Bank getInstance(){ // 方法一：同步方法
//        if (instance == null){
//            instance = new Bank();
//        }
//        return instance;
//    }

    public static Bank getInstance(){

//        synchronized (Bank.class) { // 方法二：同步代码块（效率稍差）
//            if (instance == null) {
//                instance = new Bank();
//            }
//            return instance;
//        }

        if (instance == null){ // 效率更高

            synchronized (Bank.class){

                if (instance == null){
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}
