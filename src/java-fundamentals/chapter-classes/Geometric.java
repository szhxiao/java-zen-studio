/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * Geometric
 */
public class Geometric {
    protected String color;
    protected double weight;

    protected Geometric() {
        this.color = "white";
        this.weight = 1.0;
    }

    protected Geometric(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }
    
    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public static void main(String[] args) {
        
    }    
}
