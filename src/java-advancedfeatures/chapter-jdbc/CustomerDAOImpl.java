/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
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
        String sql = "SELECT id, name, email, birth, FROM customers WHERE id=?";
        Customer customer = getInstance(connection, Customer.class, sql, id);
        return  customer;
    }

    @Override
    public List<Customer> getAll(Connection connection) {
        String sql = "SELECT id, name, email, birth FROM customers";
        List<Customer> list = getForList(connection, Customer.class, sql);
        return list;
    }


    public static void main(String[] args) {
        CustomerDAOImpl customerDAO = new CustomerDAOImpl();

        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();

            Customer customer = new Customer(1, "小宇",
                    "xiaoyu@163.com", new Date(LocalDate.now().toEpochDay()));

            customerDAO.insert(conn, customer);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
