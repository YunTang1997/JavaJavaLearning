package senior.java.reflection;

import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * 通过反射创建对应的[运行时类的对象]
 * @author YunTang
 * @create 2020-08-01 14:59
 */
public class NewInstanceTest {

    @Test
    public void test1() throws IllegalAccessException, InstantiationException {

        Class<Person> clazz = Person.class;
        /*
        newInstance()：调用此方法，创建对应的运行时类的对象。内部调用了运行时类的[空参的]构造器。

        要想此方法正常的创建运行时类的对象，要求：
        1.运行时类必须提供[空参的]构造器
        2.空参的构造器的访问权限得够。通常设置为public。

        在javabean中要求提供一个public的空参构造器。原因：
        1.便于通过反射，创建运行时类的对象
        2.便于子类继承此运行时类时，默认调用super()时，保证父类有此构造器
         */
        Person person = clazz.newInstance();

        System.out.println(person);
    }

    // 体会反射的动态性
    @Test
    public void test2(){

        String classPath = "";
        for (int j = 0; j < 10; j++) {

            int i = new Random().nextInt(3);

            switch (i){
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = "senior.java.reflection.Person";
                    break;
            }
            try {
                Object instance = getInstance(classPath);
                System.out.println(instance);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /*
    创建一个指定类的对象。
    classPath:指定类的全类名
     */
    public Object getInstance(String classPath) throws Exception {

        Class clazz = Class.forName(classPath);
        Object instance = clazz.newInstance();
        return instance;
    }

}
