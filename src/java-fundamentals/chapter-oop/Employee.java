/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 抽象员工类
 */
public abstract class Employee {
    private String name;
    private int id;
    private MyDate birthday;

    /**
     * 
     */
    public Employee() {
    }

    /**
     * @param name
     * @param id
     * @param birthday
     */
    public Employee(String name, int id, MyDate birthday) {
        this.name = name;
        this.id = id;
        this.birthday = birthday;
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

    /**
     * @return the birthday
     */
    public MyDate getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    // abstract method
    public abstract double earnings();

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    @Override
    public String toString() {
        return "name=" + name + ", id=" + id + ", birthday=" + birthday.toDateString();
    }



    public static void main(String[] args) {
        
    }    
}