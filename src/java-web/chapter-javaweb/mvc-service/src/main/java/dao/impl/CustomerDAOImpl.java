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
import util.JDBCUtils;

import java.sql.Connection;
import java.util.List;

/**
 * 
 */
public class CustomerDAOImpl extends BaseDAO implements CustomerDAO {

    private Connection connection = null;

    public CustomerDAOImpl() {
        try {
            connection = JDBCUtils.getInstance().getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Customer customer) {
        String sql = "INSERT INTO customers(name,email,birth) VALUES(?,?,?)";
        update(connection, sql,
                customer.getName(), customer.getEmail(), customer.getBirth());
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM customers WHERE id=?";
        update(connection, sql, id);
    }

    @Override
    public void update(Customer customer) {
        String sql = "UPDATE customers SET name=?, email=?, birth=? WHERE id=?";
        update(connection, sql, customer.getName(), customer.getEmail(), customer.getBirth(), customer.getId());
    }

    @Override
    public Customer getCustomerByID(int id) {
        String sql = "SELECT id, name, email, birth FROM customers WHERE id=?";
        Customer customer = getInstance(connection, Customer.class, sql, id);
        return  customer;
    }

    @Override
    public List<Customer> getAll() {
        String sql = "SELECT id, name, email, birth FROM customers";
        List<Customer> list = getForList(connection, Customer.class, sql);
        return list;
    }

    @Override
    public List<Customer> getAll(String keyword, Integer pageNo) {
        String sql = "SELECT id, name, email, birth FROM customers WHERE name" +
                " like ? LIMIT ?, 10";
        List<Customer> list = getForList(connection, Customer.class, sql,
                "%"+keyword+"%", (pageNo-1)*10);
        return list;
    }

    @Override
    public int getCustomerCount(String keyword) {
        String sql = "SELECT COUNT(*) FROM customers WHERE name like ?";
        return ((Long)getValue(connection, sql, "%"+keyword+"%")).intValue();
    }


    public static void main(String[] args) {
    }
}
