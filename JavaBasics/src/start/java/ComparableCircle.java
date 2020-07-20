package start.java;

/**
 * @author YunTang
 * @create 2020-07-20 15:29
 */

public class ComparableCircle extends Circle1 implements CompareObject{

    public ComparableCircle(double redius){
        super(redius);
    }

    @Override
    public int compare(Object o) {
        if (this == o) {
            return 0;
        }

        if (o instanceof ComparableCircle) {
            ComparableCircle c = (ComparableCircle) o;
            if (this.getRedius() > c.getRedius()) {
                return 1;
            } else if (this.getRedius() < c.getRedius()) {
                return -1;
            } else {
                return 0;
            }
        }
        else {
//            return 0;
            throw new RuntimeException("传入的参数错误");
        }
    }
}
