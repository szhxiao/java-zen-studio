/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * Employee
 */
public class Employee implements Comparable {
    private String name;
    private int age;
    private MyDate birthday;
    
    /**
     * 
     */
    public Employee() {
    }

    /**
     * @param name
     * @param age
     * @param birthday
     */
    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
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

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    @Override
    public String toString() {
        return "Employee {" + name + ", " + age + ", " + birthday + "}";
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Employee) {
            Employee e = (Employee) o;
            return this.getName().compareTo(e.getName());
        } else {
            throw new RuntimeException("异常：类型匹配错误");
        }
    }

    public static void main(String[] args) {
        
    }    
}
