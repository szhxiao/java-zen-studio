/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package service.impl;

import dao.CustomerDAO;
import entry.Customer;
import service.CustomerService;
import util.JDBCUtils;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    // 与数据库分页查询数相同
    private static final int ITEMS_PER_PAGE = 10;

    private CustomerDAO customerDAO = null;

    @Override
    public void addCustomer(Customer customer) {
        customerDAO.add(customer);
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerDAO.deleteById(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerDAO.update(customer);
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customerDAO.getCustomerById(id);
    }

    @Override
    public List<Customer> getCustomerList(String keyword, Integer pageNo) {
        return customerDAO.getAll(keyword, pageNo);
    }

    @Override
    public Integer getPageCount(String keyword) {
        int customerCount = customerDAO.getCustomerCount(keyword);
        return (customerCount + ITEMS_PER_PAGE - 1) / ITEMS_PER_PAGE;
    }
}
