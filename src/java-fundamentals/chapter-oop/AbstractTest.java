/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 抽象类
 */
abstract class Vegetables {
    String name;
    double weight;
    double price;

    public Vegetables() {}

    public Vegetables(String name, double weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    // 抽象方法不能提供方法实现
    public abstract void sow();

    public void grow() {
        System.out.println(name + " is growing up");
    }
}

class Tomato extends Vegetables {

    public Tomato() {}
    
    public Tomato(String name, double weight, double price) {
        super(name, weight, price);
    }

    // 子类必须提供父类抽象方法的实现
    public void sow() {
        System.out.println("sow tomatoes");
    }
}

public class AbstractTest {
    public static void main(String[] args) {
        // Vegetables v = new Vegetables();
        Tomato t = new Tomato("tomato", 0.32, 1.54);
        t.sow();
        t.grow();
    }    
}