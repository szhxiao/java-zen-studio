/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * Status
 */
// public class Status {
//     private final String NAME;

//     private Status(String name) {
//         this.NAME = name;
//     }

//     public static final Status FREE = new Status("FREE");
//     public static final Status BUSY = new Status("BUSY");
//     public static final Status VOCATION = new Status("VOCATION");

//     public String getNAME() {
//         return NAME;
//     }

//     /* (non-Javadoc)
//      * @see java.lang.Object#toString()
//      */
    
//     @Override
//     public String toString() {
//         return NAME;
//     }
// }

public enum Status {
    FREE, BUSY, VOCATION;
}
