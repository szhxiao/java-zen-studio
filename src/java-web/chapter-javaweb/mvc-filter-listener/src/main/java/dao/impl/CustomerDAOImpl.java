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
import exception.DAOException;

import java.sql.SQLException;
import java.util.List;

/**
 * 
 */
public class CustomerDAOImpl extends BaseDAO implements CustomerDAO {

    @Override
    public void add(Customer customer) {
        String sql = "INSERT INTO customers(name,email,birth) VALUES(?,?,?)";
        try {
            update(sql, customer.getName(), customer.getEmail(), customer.getBirth());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException("Exception in add() of " +
                    "CustomerDAOImpl");
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM customers WHERE id=?";
        try {
            update(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException("Exception in deleteById() of " +
                    "CustomerDAOImpl");
        }
    }

    @Override
    public void update(Customer customer) {
        String sql = "UPDATE customers SET name=?, email=?, birth=? WHERE id=?";
        try {
            update(sql, customer.getName(), customer.getEmail(), customer.getBirth(), customer.getId());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException("Exception in update() of " +
                    "CustomerDAOImpl");
        }
    }

    @Override
    public Customer getCustomerById(int id) {
        String sql = "SELECT id, name, email, birth FROM customers WHERE id=?";
        Customer customer = null;
        try {
            customer = getInstance(Customer.class, sql, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DAOException("Exception in getCustomerById() of" +
                    "CustomerDAOImpl");
        }
        return  customer;
    }

    @Override
    public List<Customer> getAll() {
        String sql = "SELECT id, name, email, birth FROM customers";
        List<Customer> list = null;
        try {
            list = getForList(Customer.class, sql);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DAOException("Exception in getAll() of " +
                    "CustomerDAOImpl");
        }
        return list;
    }

    @Override
    public List<Customer> getAll(String keyword, Integer pageNo) {
        String sql = "SELECT id, name, email, birth FROM customers WHERE name" +
                " like ? LIMIT ?, 10";
        List<Customer> list = null;
        try {
            list = getForList(Customer.class, sql,
                    "%"+keyword+"%", (pageNo-1)*10);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DAOException("Exception in getAll(keyword, " +
                    "pageNo) of CustomerDAOImpl");
        }
        return list;
    }

    @Override
    public int getCustomerCount(String keyword) {
        String sql = "SELECT COUNT(*) FROM customers WHERE name like ?";
        try {
            return ((Long)getValue(sql, "%"+keyword+"%")).intValue();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException("Exception in getCustomerCount() " +
                    "of CustomerDAOImpl");
        }
    }


    public static void main(String[] args) {
    }
}
