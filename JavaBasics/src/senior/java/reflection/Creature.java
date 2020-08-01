package senior.java.reflection;

import java.io.Serializable;

/**
 * @author YunTang
 * @create 2020-08-01 18:27
 */

public class Creature<T> implements Serializable {

    private char gender;
    public double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }

    public void eat(){
        System.out.println("生物吃东西");
    }
}
