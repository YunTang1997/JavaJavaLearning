package senior.java.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author YunTang
 * @create 2020-08-01 18:52
 */

public class FileTest {

    @Test
    public void test1(){

        Class clazz = Person1.class;

        // 获取属性结构
        // getFields():获取当前运行时类及其父类中声明为public访问权限的属性
        Field[] filds = clazz.getFields();
        for (Field f : filds){
            System.out.println(f);
        }

        System.out.println("**********************");

        // //getDeclaredFields()：获取当前运行时类中声明的所有属性。（不包含父类中声明的属性）
        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field f : declaredFields){
            System.out.println(f);
        }

    }

    // 权限修饰符  数据类型 变量名
    @Test
    public void test2(){

        Class<Person1> clazz = Person1.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields){

            int modifiers = f.getModifiers();
            System.out.println("权限修饰符为：" + Modifier.toString(modifiers));

            Class<?> type = f.getType();
            System.out.println("数据类型为：" + type.getName());

            String name = f.getName();
            System.out.println("属性名为：" + name);

            System.out.println("**********************");
        }
    }
}
