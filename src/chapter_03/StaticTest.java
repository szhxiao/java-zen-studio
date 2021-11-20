/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * static关键字
 */

class Chinese {
    private String name;
    private int age;

    static String nation;

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
     * @return the age
     */
    public int getAge() {
        return age;
    }
    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    public static void info() {
        System.out.println("Chinese info");
    }

    public String toString() {
        info();
        return "Name: " + name + ", Age: " + age;
    }
}

public class StaticTest {
    
    public static void main(String[] args) {
        Chinese.nation = "中国";
        Chinese.info();

        Chinese c1 = new Chinese();
        c1.setName("纳兰性德");
        c1.setAge(36);

        Chinese c2 = new Chinese();
        c2.setName("李清照");
        c2.setAge(28);
        System.out.println(c2.nation);
    }    
}