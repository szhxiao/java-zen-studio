/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package service;

import entry.Customer;

import java.util.List;

public interface CustomerService {

    /**
     * 添加用户
     *
     * @param customer 用户对象
     */
    void addCustomer(Customer customer);

    /**
     * 删除用户
     *
     * @param id 用户id
     */
    void deleteCustomer(Integer id);

    /**
     * 更新用户
     *
     * @param customer 用户对象
     */
    void updateCustomer(Customer customer);

    /**
     * 获取指定用户
     *
     * @param id 用户id
     * @return
     */
    Customer getCustomerById(Integer id);

    /**
     * 获取用户列表
     *
     * @param keyword 查询关键字
     * @param pageNo 页数
     * @return
     */
    List<Customer> getCustomerList(String keyword, Integer pageNo);

    /**
     * 获取页数
     *
     * @param keyword 查询关键字
     * @return
     */
    Integer getPageCount(String keyword);
}
