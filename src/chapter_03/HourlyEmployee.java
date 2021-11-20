/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 
 */
public class HourlyEmployee extends Employee {
    private int wage;   // 每小时工资
    private int hour;   // 工作时长

    /**
     * 
     */
    public HourlyEmployee() {
    }

    /**
     * @param name
     * @param id
     * @param birthday
     */
    public HourlyEmployee(String name, int id, MyDate birthday) {
        super(name, id, birthday);
    }

    /**
     * @param name
     * @param id
     * @param birthday
     * @param wage
     * @param hour
     */
    public HourlyEmployee(String name, int id, MyDate birthday, int wage, int hour) {
        super(name, id, birthday);
        this.wage = wage;
        this.hour = hour;
    }

    /**
     * @return the wage
     */
    public int getWage() {
        return wage;
    }

    /**
     * @param wage the wage to set
     */
    public void setWage(int wage) {
        this.wage = wage;
    }

    /**
     * @return the hour
     */
    public int getHour() {
        return hour;
    }

    /**
     * @param hour the hour to set
     */
    public void setHour(int hour) {
        this.hour = hour;
    }

    @Override
    public double earnings() {
        return wage * hour;
        
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    @Override
    public String toString() {
        return "HourlyEmployee [" + super.toString() + "]";
    }

    public static void main(String[] args) {
        
    }

}