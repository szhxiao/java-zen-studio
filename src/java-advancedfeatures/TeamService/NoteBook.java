/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 
 */
public class NoteBook implements Equipment {
    private String model;
    private double price;
    /**
     * 
     */
    public NoteBook() {
    }

    /**
     * @param model
     * @param price
     */
    public NoteBook(String model, double price) {
        this.model = model;
        this.price = price;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
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
    public String getDescription() {
        return model + "(" + price + ")";
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    @Override
    public String toString() {
        return "NoteBook[" + this.getModel() + ", " + this.getPrice() + "]";
    }

    
}
