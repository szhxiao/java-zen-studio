/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 使用同步机制将单例模式中懒汉式改写为线程安全的
 */

class Bank {
    private Bank() {}

    private static Bank instance = null;

    // 方式一
    
    // public static synchronized Bank getInstance() {
    //     if (instance == null) {
    //         instance = new Bank();
    //     }
    //     return instance;
    // }
    
    // 方式二，效率较差  
    // public static Bank getInstance() {
    //     synchronized(Bank.class) {
    //         if (instance == null) {
    //             instance = new Bank();
    //         }
    //         return instance;
    //     }
    // }

    // 方式三
    public static Bank getInstance() {
        if (instance == null) {
            synchronized(Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}

public class WindowTest {
    
    public static void main(String[] args) {
        

    }    
}
