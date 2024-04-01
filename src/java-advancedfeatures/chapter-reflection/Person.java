/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 
 */
public class Person {

    private String name;
    private int age;
    public int id;
    
    /**
     * 
     */
    public Person() {
        System.out.println("Person()");
    }

    private Person(String name) {
        this.name = name;
    }
    
    /**
     * @param name
     * @param age
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }

    private void show(String nation) {
        System.out.println("I'm a " + nation);
    }


    public static void main(String[] args) {
        
    }    
}
