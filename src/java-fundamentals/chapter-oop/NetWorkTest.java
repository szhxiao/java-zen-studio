/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 接口
 */

interface NetWork {
    void browse();
}

class NetServer implements NetWork {
    @Override
    public void browse() {
        System.out.println("net server is browsing");
    }
}

class ProxyServer implements NetWork {
    private NetWork work;

    public ProxyServer(NetWork work) {
        this.work = work;
    }

    public void check() {
        System.out.println("proxy server is checking");
    }

    @Override
    public void browse() {
        check();
        work.browse();
    }
    
}

public class NetWorkTest {
    public static void main(String[] args) {
        NetServer server = new NetServer();
        ProxyServer proxyServer = new ProxyServer(server);
        proxyServer.browse();
    }
}