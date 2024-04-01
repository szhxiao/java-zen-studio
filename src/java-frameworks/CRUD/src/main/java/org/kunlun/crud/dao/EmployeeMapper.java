/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.kunlun.crud.dao;

import org.kunlun.crud.pojo.Employee;

import java.util.List;

public interface EmployeeMapper {

    /**
     * 根据id查询员工
     *
     * @param empId 员工id
     * @return
     */
    Employee getEmployeeById(Integer empId);

    /**
     * 根据员工名查询
     * @param empName
     * @return
     */
    Employee getEmployeeByName(String empName);

    /**
     * 根据员工名模糊查询
     *
     * @param empName
     * @return
     */
    List<Employee> listEmployeesByName(String empName);

    /**
     * 查询所有员工
     *
     * @return
     */
    List<Employee> listEmployees();

    List<Employee> listEmployeesWithDepartment();

    /**
     * 添加员工信息
     *
     * @param employee
     */
    void insertEmployee(Employee employee);

    /**
     * 修改员工信息
     *
     * @param employee
     */
    void updateEmployee(Employee employee);

    /**
     * 根据员工id删除员工信息
     *
     * @param empId
     */
    void deleteEmployee(Integer empId);

    // Integer countByCondition();

    void deleteEmployeeBatch(Integer[] empIds);
}