/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 
 */
public class Goods implements Comparable {
    private String name;
    private double price;

    /**
     * 
     */
    public Goods() {
    }
    
    /**
     * @param name
     * @param price
     */
    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods) {
            Goods goods = (Goods) o;
            if (this.price > goods.price) {
                return 1;
            } else if(this.price < goods.price) {
                return -1;
            } else {
                return 0;
            }

            // return Double.compare(this.price, goods.price);
        }
        
        throw new RuntimeException("提示：数据类型异常");
    }

    @Override
    public String toString() {
        return "{" + this.name + ", " + this.price + "}";
    }

    public static void main(String[] args) {
        
    }    
}
