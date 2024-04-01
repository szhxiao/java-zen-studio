/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 
 */
public class Girl {
    private String name;
    
    /**
     * 
     */
    public Girl() {
    }

    /**
     * @param name
     */
    public Girl(String name) {
        this.name = name;
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

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    @Override
    public String toString() {
        return "Girl [name=" + name + "]";
    }

    public static void main(String[] args) {
        
    }    
}
