/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 定义类
 */
public class Customer {
    private String firstName;
    private String lastName;
    private Account account;

    public Customer() {}

    /**
     * @param firstName the customer's first name
     * @param lastName the customer's last name
     */
    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the account
     */
    public Account getAccount() {
        return account;
    }

    /**
     * @param account the account to set
     */
    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Customer [" + lastName + ", " + firstName + "] has a account: \n id is "
            + account.getId() + ",\n annualIntestRate is " + account.getAnnualInterstRate()
            + ",\n balance is " + account.getBalance();

    }

    public static void main(String[] args) {
        Customer customer = new Customer("Jane", "Smith");      
        Account account = new Account(1000, 2000, 0.0123);

        customer.setAccount(account);
        customer.getAccount().deposit(100);
        customer.getAccount().withdraw(960);
        customer.getAccount().withdraw(2000);
        System.out.println(customer);
    }
}
