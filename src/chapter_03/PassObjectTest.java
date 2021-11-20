/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 参数传递
 */

public class PassObjectTest {

    public void printAreas(Circle c, int time) {
        for (int i = 1; i <= time; i++) {
            c.setRadius(i);
            System.out.println(i + "\t" + c.findArea());
        }

        c.setRadius(time + 1);
    }
    public static void main(String[] args) {
        PassObjectTest pot = new PassObjectTest();
        Circle c = new Circle();
        pot.printAreas(c, 5);

        System.out.println("now radius is " + c.getRadius());
    }    
}

class Circle {
    private double radius;

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
     * Return area of the circle
     * 
     * @return area of the circle
     */
    public double findArea() {
        return Math.PI * radius * radius;
    }
}
