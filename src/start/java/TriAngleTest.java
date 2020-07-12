package start.java;

/**
 * @author YunTang
 * @create 2020-07-12 19:28
 */
public class TriAngleTest {

    public static void main(String[] args) {

        TriAngle t1 = new TriAngle();
        t1.setBase(2.0);
        t1.setHeight(5.9);
        System.out.println("base: " + t1.getBase() + "\theight: " + t1.getHeight());

        TriAngle t2 = new TriAngle(5.9, 8.1);
        System.out.println("base: " + t2.getBase() + "\theight: " + t2.getHeight());
    }
}
