/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * Programmer
 */
public class Programmer extends Employee {
    private int memberId;
    private Status status = Status.FREE;
    private Equipment equipment;
    
    /**
     * 
     */
    public Programmer() {
        super();
    }

    /**
     * @param equipment
     */
    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    /**
     * @return the memberId
     */
    public int getMemberId() {
        return memberId;
    }

    /**
     * @param memberId the memberId to set
     */
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    /**
     * @return the status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * @return the equipment
     */
    public Equipment getEquipment() {
        return equipment;
    }

    /**
     * @param equipment the equipment to set
     */
    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    @Override
    public String toString() {
        return this.getInfo() + "\t" + "Programmer" + "\t" 
            + this.getStatus() + "\t\t\t" + this.getEquipment();
    }

    public String toTeamString() {
        return this.getMemberId() + "/" + this.getId() + "\t"
            + this.getName() + "\t" + this.getAge() + "\t"
            + this.getSalary() + "\t" + "Programmer";
    }
}
