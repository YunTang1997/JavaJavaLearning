package start.java;

import org.omg.PortableServer.SERVANT_RETENTION_POLICY_ID;

/**
 * @author YunTang
 * @create 2020-07-19 21:06
 */

/*
代理模式是Java开发中使用较多的一种设计模式。代理设计就是为其他对象提供一种代理以控制对这个对象的访问。
 */

public class NetWorkTest {

    public static void main(String[] args) {
        Server server = new Server();
        ProxyServer proxyServer = new ProxyServer(server); // 多态
        proxyServer.browse();
    }
}

interface NetWork{

    public abstract void browse();

}

// 被代理类
class Server implements NetWork{

    @Override
    public void browse() {
        System.out.println("真实的服务器访问网络");
    }
}

// 代理类
class ProxyServer implements NetWork{

    private NetWork work; // 声明一个接口

    // 代理类的构造器
    public ProxyServer(NetWork work){
        this.work = work;
    }

    public void check(){
        System.out.println("联网之前的检查操作");
    }

    @Override
    public void browse() {
        check();
        work.browse();
    }
}