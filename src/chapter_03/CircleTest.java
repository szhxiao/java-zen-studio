/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * static关键字
 */

class Circle {
    private double radius;
    private int id;

    private static int total = 0;
    private static int init = 1001;     // 多个对象共享

    public Circle() {
        id = init++;
        total++;
    }

    public Circle(double radius) {
        this();
        this.radius = radius;
    }

    /**
     * @return the radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * @param radius the radius to set
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    // public void setId(int id) {
    //     this.id = id;
    // }

    public double getArea() {
        return Math.PI * radius * radius;
    }
}

public class CircleTest {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        Circle c2 = new Circle();

        System.out.println("c1.id = " + c1.getId());
        System.out.println("c2.id = " + c2.getId());
    }    
}