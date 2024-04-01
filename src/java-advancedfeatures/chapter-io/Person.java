import java.io.Serializable;

/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 
 */
public class Person implements Serializable{
    public static final long serialVersionUID = 3837404832L;

    private String name;
    private int age;
    private String gender;
    
    /**
     * 
     */
    public Person() {
    }

    /**
     * @param name
     * @param age
     * @param gender
     */
    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
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

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
    }

    public static void main(String[] args) {
        
    }    
}
