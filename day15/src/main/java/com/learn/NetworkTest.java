package com.learn;

/**
 * 接口的应用——代理模式
 */
public class NetworkTest {
    public static void main(String[] args) {
        ProxyServer proxyServer = new ProxyServer(new Server());
        proxyServer.browse();
    }
}

interface Network {
    void browse();
}

/**
 * 被代理类
 */
class Server implements Network {

    public void browse() {
        System.out.println("真实的server访问网络");
    }

}

/**
 * 代理类
 */
class ProxyServer implements Network {

    private Network network;

    public ProxyServer(Network network) {
        this.network = network;
    }

    public void check() {
        System.out.println("联网之前的检查工作");
    }

    public void browse() {
        check();
        network.browse();
    }
}