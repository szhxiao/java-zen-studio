/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 
 */
public class Boy {
    private Gril gril;
    
    /**
     * 
     */
    public Boy() {
    }

    /**
     * @param gril
     */
    public Boy(Gril gril) {
        this.gril = gril;
    }

    /**
     * @return the gril
     */
    public Gril getGril() {
        return gril;
    }

    /**
     * @param gril the gril to set
     */
    public void setGril(Gril gril) {
        this.gril = gril;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    @Override
    public String toString() {
        return "Boy [gril=" + gril + "]";
    }

    public static void main(String[] args) {
        
    }    
}
