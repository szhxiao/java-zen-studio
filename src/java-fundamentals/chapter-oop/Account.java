/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 
 */
public class Account {
    private int id;                     // 账号
    private double balance;             // 余额
    private double annualInterstRate;   // 年利率

    public Account(int id, double balance, double annualInterstRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterstRate = annualInterstRate;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * @return the annualInterstRate
     */
    public double getAnnualInterstRate() {
        return annualInterstRate;
    }

    /**
     * @param annualInterstRate the annualInterstRate to set
     */
    public void setAnnualInterstRate(double annualInterstRate) {
        this.annualInterstRate = annualInterstRate;
    }

    public void withdraw(double amount) {
        if (balance < amount) {
            System.out.println("余额不足，取款失败");
        } else {
            balance -= amount;
            System.out.println("成功取出：" + amount);
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("成功存入：" + amount);
        }
    }

    public static void main(String[] args) {
        
    }    
}
