package senior.java.reflection;

/**
 * 静态代理举例
 *
 * 特点：代理类和被代理类在编译期间，就确定下来了。
 * @author YunTang
 * @create 2020-08-02 10:11
 */

public class StaticProxyTest {

    public static void main(String[] args) {
        // 创建被代理类对象
        NikeFactory nikeFactory = new NikeFactory();
        // 创建代理类对象
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nikeFactory);
        proxyClothFactory.produceCloth();
    }
}

interface ClothFactory{

    void produceCloth();
}

// 代理类
class ProxyClothFactory implements ClothFactory{

    private ClothFactory factory; // 用被代理类对象进行实例化
    public ProxyClothFactory(ClothFactory factory){
        this.factory = factory;
    }
    @Override
    public void produceCloth() {
        System.out.println("服装工厂做一些准备工作");
        factory.produceCloth();
        System.out.println("服装工厂完成任务");
    }
}

// 被代理类
class NikeFactory implements ClothFactory{
    @Override
    public void produceCloth() {
        System.out.println("生产Nike运动装");
    }
}
