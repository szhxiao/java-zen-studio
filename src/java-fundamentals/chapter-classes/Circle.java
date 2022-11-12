import java.util.Objects;

/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * Geometric
 */
public class Circle extends Geometric {
    private double radius;

    public Circle() {
        super("white", 1.0);
        this.radius = 1.0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, double weight) {
        super(color, weight);
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

    

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return false;
        }

        if (obj instanceof Circle) {
            Circle circle = (Circle) obj;
            return this.radius == circle.radius;
        }
        return false;
    }

    public String toString() {
        return "Circle [radius = " + radius + "]";
    }

    public static void main(String[] args) {
        
    }    
}
