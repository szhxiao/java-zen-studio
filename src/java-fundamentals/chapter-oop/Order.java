/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 测试4种访问权限控制
 */

public class Order {
    private int orderPrivate;
    int orderDefault;
    protected int orderProtected;
    public int orderPublic;

    private void methodPrivate() {
        System.out.println("private method");
    }

    void methodDefault() {
        System.out.println("default method");
    }

    protected void methodProtected() {
        System.out.println("protected method");
    }

    public void methodPublic() {
        System.out.println("public method");
    }
    
    public static void main(String[] args) {
        
    }    
}

