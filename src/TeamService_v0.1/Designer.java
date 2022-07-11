/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * Designer
 */
public class Designer extends Programmer {
    private double bonus;

    /**
     * 
     */
    public Designer() {
        super();
    }

    /**
     * @param bonus
     */
    public Designer(int id, String name, int age, double salary, 
        Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
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

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    @Override
    public String toString() {
        // super(id, name, age, salary, equipment);
        // this.bonus = bonus;
        return this.getInfo() + "\t" + "Designer" + "\t" 
            + this.getStatus() + "\t" + this.getBonus() + "\t\t" 
            + this.getEquipment();
    }
    
    @Override
    public String toTeamString() {
        return this.getMemberId() + "/" + this.getId() + "\t"
            + this.getName() + "\t" + this.getAge() + "\t"
            + this.getSalary() + "\t" + "Designer" + "\t"
            + this.getBonus();
    }
}
