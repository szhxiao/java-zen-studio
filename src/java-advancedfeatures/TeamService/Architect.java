/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * Architect
 */
public class Architect extends Designer {
    private int stock;

    /**
     * 
     */
    public Architect() {
        super();
    }

    /**
     * @param stock
     */
    public Architect(int id, String name, int age, double salary, 
        Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    @Override
    public String toString() {
        // super(id, name, age, salary, equipment, bonus);
        // this.stock = stock;
        return this.getInfo() + "\t" + "Architect" + "\t" 
            + this.getStatus() + "\t" + this.getBonus() + "\t" 
            + this.getStock() + "\t" + this.getEquipment();
    }

    @Override
    public String toTeamString() {
        return this.getMemberId() + "/" + this.getId() + "\t"
            + this.getName() + "\t" + this.getAge() + "\t"
            + this.getSalary() + "\t" + "Architect" + "\t"
            + this.getBonus() + "\t" + this.getStock();
    }
}
