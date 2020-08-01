package senior.java.reflection;

/**
 * @author YunTang
 * @create 2020-08-01 18:32
 */

@MyAnnotation(value = "hi")
public class Person1 extends Creature implements Comparable<String>, MyInterface{

    private String name;
    int age;
    public int id;

    public Person1() {

    }

    @MyAnnotation(value = "abc")
    private Person1(String name) {
        this.name = name;
    }

    Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @MyAnnotation
    private String show(String nation) {
        System.out.println("我的国籍是：" + nation);
        return nation;
    }

    public String display(String interests, int age) {
        return interests + age;
    }

    @Override
    public void info() {
        System.out.println("我是一个人");
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    private static void showDesc() {
        System.out.println("我是一个可爱的人");
    }

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';

    }
}
