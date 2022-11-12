/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 抽象类
 */
public class Manager extends Employee {
    private double bonus;

    /**
     * 
     */
    public Manager() {
    }

    /**
     * @param name
     * @param id
     * @param salary
     * @param bonus
     */
    public Manager(String name, int id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    /**
     * @return the bonus
     */
    public double getBonus() {
        return bonus;
    }

    /**
     * @param bonus the bonus to set
     */
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("Manage work");
    }    

    public static void main(String[] args) {
        Manager m = new Manager("Tom", 1001, 5000.0, 50000.0);
        m.work();
    }
}