package start.java;

/**
 * @author YunTang
 * @create 2020-07-12 18:38
 */
public class OrderTest {

    public static void main(String[] args) {
        Order order = new Order();
        order.orderDefault = 1;
        order.orderPublic = 1;
        // 除了Order类之后，私有的结构就不可以调用了
        // order.orderPrivate = 1; // 'orderPrivate' has private access in 'start.java.Order'

        order.methodDefault();
        order.methodPublic();
        // order.methodPrivate(); // 'methodPrivate()' has private access in 'start.java.Order'
    }

}
