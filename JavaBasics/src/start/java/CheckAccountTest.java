package start.java;

/**
 * @author YunTang
 * @create 2020-07-17 9:48
 */

/*
写一个用户程序测试CheckAccount类。在用户程序中，创建一个账号为 1122、余
额为 20000、年利率4.5%，可透支限额为5000元的CheckAccount对象。
使用withdraw方法提款5000元，并打印账户余额和可透支额。
再使用withdraw方法提款18000元，并打印账户余额和可透支额。
再使用withdraw方法提款3000元，并打印账户余额和可透支额。
 */
public class CheckAccountTest {

    public static void main(String[] args) {

        CheckAccount checkAccount = new CheckAccount(1122, 20000, 0.045, 5000);

        checkAccount.withdraw(5000);
        System.out.println("您的帐户余额为:" + checkAccount.getBalance());
        System.out.println("您的可透支额度为:" + checkAccount.getOverdraft());
        checkAccount.withdraw(18000);
        System.out.println("您的帐户余额为:" + checkAccount.getBalance());
        System.out.println("您的可透支额度为:" + checkAccount.getOverdraft());
        checkAccount.withdraw(3000);
        System.out.println("您的帐户余额为:" + checkAccount.getBalance());
        System.out.println("您的可透支额度为:" + checkAccount.getOverdraft());
    }
}
