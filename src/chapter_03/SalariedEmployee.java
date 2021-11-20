/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 
 */
public class SalariedEmployee extends Employee {
    private double monthlySalary;
    
    /**
     * 
     */
    public SalariedEmployee() {
    }

    /**
     * @param name
     * @param id
     * @param birthday
     */
    public SalariedEmployee(String name, int id, MyDate birthday) {
        super(name, id, birthday);
    }

    /**
     * @param name
     * @param id
     * @param birthday
     * @param monthlySalary
     */
    public SalariedEmployee(String name, int id, MyDate birthday, double monthlySalary) {
        super(name, id, birthday);
        this.monthlySalary = monthlySalary;
    }

    /**
     * @return the salary
     */
    public double getMonthlySalary() {
        return monthlySalary;
    }

    /**
     * @param salary the salary to set
     */
    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double earnings() {
        return monthlySalary;
        
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    @Override
    public String toString() {
        return "SalariedEmployee [" + super.toString() + "]";
    }

    public static void main(String[] args) {
        
    }

}