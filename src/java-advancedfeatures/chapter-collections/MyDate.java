/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * MyDate
 */
public class MyDate {
    private int year;
    private byte month;
    private byte day;
    
    /**
     * 
     */
    public MyDate() {
    }

    /**
     * @param year
     * @param month
     * @param day
     */
    public MyDate(int year, byte month, byte day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return the month
     */
    public byte getMonth() {
        return month;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(byte month) {
        this.month = month;
    }

    /**
     * @return the day
     */
    public byte getDay() {
        return day;
    }

    /**
     * @param day the day to set
     */
    public void setDay(byte day) {
        this.day = day;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    @Override
    public String toString() {
        return "[" + year + ", " + month + ", " + day + "]";
    }

    public static void main(String[] args) {
        
    }    
}
