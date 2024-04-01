/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

package dao.impl;

import dao.BaseDAO;
import dao.CustomerDAO;
import entry.Customer;

import java.sql.Connection;
import java.util.List;

/**
 * 
 */
public class CustomerDAOImpl extends BaseDAO implements CustomerDAO {

    @Override
    public void insert(Connection connection, Customer customer) {
        String sql = "INSERT INTO customers(name,email,birth) VALUES(?,?,?)";
        update(connection, sql, customer.getName(), customer.getEmail(), customer.getBirth());
    }

    @Override
    public void deleteById(Connection connection, int id) {
        String sql = "DELETE FROM customers WHERE id=?";
        update(connection, sql, id);
    }

    @Override
    public void update(Connection connection, Customer customer) {
        String sql = "UPDATE customers SET name=?, email=?, birth=? WHERE id=?";
        update(connection, sql, customer.getName(), customer.getEmail(), customer.getBirth(), customer.getId());
    }

    @Override
    public Customer getCustomerByID(Connection connection, int id) {
        String sql = "SELECT id, name, email, birth FROM customers WHERE id=?";
        Customer customer = getInstance(connection, Customer.class, sql, id);
        return  customer;
    }

    @Override
    public List<Customer> getAll(Connection connection) {
        String sql = "SELECT id, name, email, birth FROM customers";
        List<Customer> list = getForList(connection, Customer.class, sql);
        return list;
    }

    @Override
    public List<Customer> getAll(Connection connection,
                                 String keyword, Integer pageNo) {
        String sql = "SELECT id, name, email, birth FROM customers WHERE name" +
                " like ? LIMIT ?, 5";
        List<Customer> list = getForList(connection, Customer.class, sql,
                "%"+keyword+"%", (pageNo-1)*5);
        return list;
    }

    @Override
    public int getCustomerCount(Connection connection, String keyword) {
        String sql = "SELECT COUNT(*) FROM customers WHERE name like ?";
        return ((Long)getValue(connection, sql, "%"+keyword+"%")).intValue();
    }


    public static void main(String[] args) {
    }
}
