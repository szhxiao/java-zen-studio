/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 定义Kids类，继承自ManKind类
 */

public class Kids extends ManKind {
    private int age;

    public Kids() {}

    public Kids(int age) {
        this.age = age;
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

    public void printAge() {
        System.out.println("I'm " + age + " years old");
    }
    
    public static void main(String[] args) {
        
    }    
}

