/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 初始化块
 */

class Manager {
    private String name;
    private int age;
    static String desc = "I'm a manager in company.";

    public Manager() {}

    public Manager(String name, int age) {
        this.name = name;
        this.age = age;
    }

    static {
        System.out.println("static block");
    }

    {
        System.out.println("block");
    }


    public void work() {
        System.out.println("I'm working");
    }

    public void meeting() {
        System.out.println("There is a meeting.");
    }

    public static void info() {
        System.out.println("test block");
    }

}

public class BlockTest {
    
    public static void main(String[] args) {
        String desc = Manager.desc;
        System.out.println(desc);

        Manager m1 = new Manager();
        Manager m2 = new Manager();
    }    
}