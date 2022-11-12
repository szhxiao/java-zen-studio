/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 客户对象管理模块
 */
public class CustomerList {
    private Customer[] customers;
    private int total = 0;

    public CustomerList(int totalCustomers) {
        customers = new Customer[totalCustomers];
    }

    /**
     * Add customer.
     * 
     * @param customer the customer to add
     * @return {@code true} if add successfully;
     *         {@code false} otherwise
     */
    public boolean addCustomer(Customer customer) {
        if (total >= customers.length) {
            return false;
        }

        customers[total] = customer;
        total++;
        return true;
    }

    /**
     * Replace the index customer by new value.
     * 
     * @param index the index
     * @param customer the customer to replace
     * @return {@code true} if replace successfully;
     *         {@code false} otherwise
     */
    public boolean replaceCustomer(int index, Customer customer) {
        if (index < 0 || index >= total) {
            return false;
        }
        customers[index] = customer;
        return true;
    }

    /**
     * Delete the index customer.
     * 
     * @param index the index
     * @return {@code true} if delete successfully;
     *         {@code false} otherwise
     */
    public boolean deleteCustomer(int index) {
        if (index < 0 || index >= total) {
            return false;
        }
        for (int i = index; i < total - 1; i++) {
            customers[i] = customers[i+1];
        }
        customers[total-1] = null;
        total--;
        return true;
    }

    /**
     * Return all customers in a array.
     * 
     * @return all customers
     */
    public Customer[] getAllCustomers() {
        Customer[] customersCopy = new Customer[total];
        for (int i = 0; i < total; i++) {
            customersCopy[i] = customers[i];
        }
        return customersCopy;
    }

    /**
     * Return the index customer.
     * 
     * @param index the index
     * @return the index customer
     */
    public Customer getCustomer(int index) {
        if (index < 0 || index >= total) {
            return null;
        }
        return customers[index];
    }

    /**
     * Return the number of customers.
     * 
     * @return the number of customers
     */
    public int getTotal() {
        return total;
    }

    public static void main(String[] args) {
        
    }
}
