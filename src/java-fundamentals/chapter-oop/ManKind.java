/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 定义ManKind类
 */

public class ManKind {
    private char gender;
    private int salary;

    public ManKind() {}

    public ManKind(char gender, int salary) {
        this.gender = gender;
        this.salary = salary;
    }

    /**
     * @return the gender
     */
    public char getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(char gender) {
        this.gender = gender;
    }

    /**
     * @return the salary
     */
    public int getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * Print gender.
     */
    public void manOrWoman() {
        if (gender == 'M') {
            System.out.println("Man");
        } else if (gender == 'F') {
            System.out.println("Woman");
        }
    }

    /**
     * Print having job or not.
     */
    public void employeed() {
        String jobInfo = (salary == 0) ? "No job" : "Having job";
        System.out.println(jobInfo);
    }
    
    public static void main(String[] args) {
        
    }    
}

