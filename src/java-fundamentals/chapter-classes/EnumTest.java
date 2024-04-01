/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * enum keyword
 */

enum Season {
    SPRING("春天", "春暖花开"),
    SUMMER("夏天", "夏日炎炎"),
    AUTUMN("秋天", "秋高气爽"),
    WINTER("冬天", "冰天雪地");

    private final String seasonName;
    private final String seasonDesc;
    
    /**
     * @param seasonName
     * @param seasonDesc
     */
    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }
}
public class EnumTest {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        // toString()
        System.out.println(spring);
        System.out.println(spring.getClass().getSuperclass());

        // values()
        Season[] values = Season.values();
        for (Season season : values) {
            System.out.println(season);
        }
    }    
}
