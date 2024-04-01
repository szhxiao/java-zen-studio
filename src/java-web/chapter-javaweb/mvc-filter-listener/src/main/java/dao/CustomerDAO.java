 /**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

 package dao;

import entry.Customer;

import java.util.List;

/**
 * 
 */
public interface CustomerDAO {

    /**
     * 将Customer对象添加到数据库
     *
     * @param customer 对象
     */
    void add(Customer customer);

    /**
     * 删除指定id对象
     *
     * @param id
     */
    void deleteById(int id);

    /**
     * 修改数据表中的指定记录
     *
     * @param customer 对象
     */
    void update(Customer customer);

    /**
     * 查询指定id对象
     *
     * @param id 对象索引
     */
    Customer getCustomerById(int id);

    /**
     * 查询表中所有记录
     *
     * @return 表中所有记录构成的集合
     */
    List<Customer> getAll();

    List<Customer> getAll(String keyword,
                          Integer pageNo);

    int getCustomerCount(String keyword);
}
