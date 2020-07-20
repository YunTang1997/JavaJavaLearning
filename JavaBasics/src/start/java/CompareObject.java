package start.java;


/**
 * @author YunTang
 * @create 2020-07-20 15:23
 */

public interface CompareObject {

    //若返回值是0，代表相等;若为正数，代表当前对象大；负数代表当前对象小
    public abstract int compare(Object o);

}

