/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 测试4种访问权限控制
 */

public class OrderTest {
    public static void main(String[] args) {
        Order order = new Order();

        // order.orderPrivate = 0;
        order.orderDefault = 1;
        order.orderProtected = 2;
        order.orderPublic = 3;

        // order.methodPrivate();
        order.methodDefault();
        order.methodProtected();
        order.methodPublic();
    }    
}

