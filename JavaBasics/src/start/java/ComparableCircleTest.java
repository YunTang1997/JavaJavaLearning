package start.java;

/**
 * @author YunTang
 * @create 2020-07-20 15:44
 */

public class ComparableCircleTest {

    public static void main(String[] args) {

        ComparableCircle c1 = new ComparableCircle(3.4);
        ComparableCircle c2 = new ComparableCircle(3.6);

        int compare = c1.compare(c2);
        if (compare > 0){
            System.out.println("c1对象大");
        }
        else if(compare < 0){
            System.out.println("c2对象大");
        }
        else{
            System.out.println("c1与c2一样大");
        }
    }
}
