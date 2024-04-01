/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 测试4种访问权限控制
 */

public class SubOrder extends Order {
    public void methodSub() {
        // 在不同包的子类中不能调用private和default修饰的属性、方法
        orderDefault = 1;
        orderProtected = 2;
        orderPublic = 3;

        // 在不同包的子类中不能调用private和default修饰的属性、方法
        methodDefault();
        methodProtected();
        methodPublic();
    }
    
    public static void main(String[] args) {
        
    }    
}

