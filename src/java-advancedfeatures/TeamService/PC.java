/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 
 */
public class PC implements Equipment {
    private String model;
    private String display;

    /**
     * 
     */
    public PC() {
    }

    /**
     * @param model
     * @param display
     */
    public PC(String model, String display) {
        this.model = model;
        this.display = display;
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
     * @return the display
     */
    public String getDisplay() {
        return display;
    }

    /**
     * @param display the display to set
     */
    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public String getDescription() {
        return getModel() + "(" + display + ")";
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    @Override
    public String toString() {
        return "PC[" + this.getModel() + ", " + this.getDisplay() + "]";
    }

    
}
