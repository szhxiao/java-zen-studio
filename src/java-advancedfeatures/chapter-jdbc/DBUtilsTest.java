/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.util.List;

/**
 * 
 */
public class DBUtilsTest {

    public static void testInsert() {
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtilsDruid.getConnection();
            String sql = "INSERT INTO customers(name,email,birth) VALUES(?,?,?)";
            runner.update(conn, sql,"比尔","bill@17663.com","1983-08-27");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtilsDruid.closeResource(conn);
        }
    }

    public static void testQuery1() {
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtilsDruid.getConnection();
            String sql = "SELECT id,name,email,birth FROM customers WHERE id=?";
            BeanHandler<Customer> handler = new BeanHandler<>(Customer.class);
            Customer customer = runner.query(conn, sql, handler, 12);
            System.out.println(customer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtilsDruid.closeResource(conn);
        }
    }

    public static void testQuery2() {
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtilsDruid.getConnection();
            String sql = "SELECT id,name,email,birth FROM customers WHERE id<?";
            BeanListHandler<Customer> handler = new BeanListHandler<>(Customer.class);
            List<Customer> customers = runner.query(conn, sql, handler, 12);
            customers.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtilsDruid.closeResource(conn);
        }
    }
    
    public static void main(String[] args) throws Exception {
//        testInsert();
//        testQuery1();
        testQuery2();
    }    
}
