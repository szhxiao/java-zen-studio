 /**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

 package dao;

import entry.Customer;

import java.sql.Connection;
import java.util.List;

/**
 * 
 */
public interface CustomerDAO {

    /**
     * 将Customer对象添加到数据库
     *
     * @param connection 数据库连接
     * @param customer 对象
     */
    void insert(Connection connection, Customer customer);

    /**
     * 删除指定id对象
     *
     * @param connection 数据库连接
     * @param id
     */
    void deleteById(Connection connection, int id);

    /**
     * 修改数据表中的指定记录
     *
     * @param connection 数据库连接
     * @param customer 对象
     */
    void update(Connection connection, Customer customer);

    /**
     * 查询指定id对象
     *
     * @param connection 数据库连接
     * @param id 对象索引
     */
    Customer getCustomerByID(Connection connection, int id);

    /**
     * 查询表中所有记录
     *
     * @param connection 数据库连接
     * @return 表中所有记录构成的集合
     */
    List<Customer> getAll(Connection connection);

    List<Customer> getAll(Connection connection, String keyword,
                          Integer pageNo);

    int getCustomerCount(Connection connection, String keyword);
}
