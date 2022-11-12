/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 
 */
public class Teacher extends Person {
    private String rand;
    private String major;
    private double salary;

    public Teacher() {}

    

    /**
     * @param name the name
     * @param age the age
     * @param gender the gender
     * @param rand the rand
     * @param major the major
     * @param salary the salary
     */
    public Teacher(String name, int age, String gender, 
        String rand, String major, double salary) {
        super(name, age, gender);
        this.rand = rand;
        this.major = major;
        this.salary = salary;
    }

    /**
     * @return the rand
     */
    public String getRand() {
        return rand;
    }

    /**
     * @param rand the rand to set
     */
    public void setRand(String rand) {
        this.rand = rand;
    }

    /**
     * @return the major
     */
    public String getMajor() {
        return major;
    }

    /**
     * @param major the major to set
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * @return the salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public void talk(String language) {
        System.out.println(super.getName() + " is having class with " + language);
    }

    public void teach() {
        System.out.println(super.getName() + " is teaching " + major);
    }
    public static void main(String[] args) {
        
    }    
}
