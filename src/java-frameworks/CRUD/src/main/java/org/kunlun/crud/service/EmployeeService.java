/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.kunlun.crud.service;

import org.kunlun.crud.dao.EmployeeMapper;

import org.kunlun.crud.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper empMapper;

    public Employee getEmployeeById(Integer empId) {
        return empMapper.getEmployeeById(empId);
    }

    public Employee getEmployeeByName(String empName) {
        return empMapper.getEmployeeByName(empName);
    }

    public List<Employee> listEmployeesByName(String empName) {
        return empMapper.listEmployeesByName("%" + empName + "%");
    }

    public List<Employee> listEmployees() {
        return empMapper.listEmployees();
    }

    public List<Employee> listEmployeesWithDepartment() {
        return empMapper.listEmployeesWithDepartment();
    }

    public void insertEmployee(Employee employee) {
        empMapper.insertEmployee(employee);
        System.out.println("Notes: employee insert done");
    }

    public void updateEmployee(Employee employee) {
        empMapper.updateEmployee(employee);
        System.out.println("Notes: employee update done");
    }

    public void deleteEmployee(Integer empId) {
        empMapper.deleteEmployee(empId);
        System.out.println("Notes: employee delete done");
    }

    public void deleteEmployeeBatch(Integer[] empIds) {
        empMapper.deleteEmployeeBatch(empIds);
        System.out.println("Notes: employee batch delete done");
    }
}
