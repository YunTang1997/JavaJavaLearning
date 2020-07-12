package start.java;

/**
 * @author YunTang
 * @create 2020-07-10 19:27
 */

public class AnonymousFunction {

    public static void main(String[] args) {

        Phone p = new Phone(); // 创建对象

        p.playGame();
        p.sendEmail();
        p.showPrice();

        // 匿名函数（注意下面两个new phone是两个不同的对象）
        new Phone().price = 1999;
        new Phone().showPrice();

        PhoneMail mail = new PhoneMail(); // 创建对象
        mail.Show(new Phone()); // 注意此处在使用匿名函数做形参的时候，在mail方法内部一直使用的是同一个对象


    }
}

class Phone{

    double price;

    public void sendEmail(){
        System.out.println("发送邮件");
    }

    public void playGame(){

        System.out.println("玩游戏");
    }

    public void showPrice(){

        System.out.println("手机的价格为：" + price);
    }
}

class PhoneMail{

    public void Show(Phone phone){

        phone.playGame();
        phone.sendEmail();
    }
}
