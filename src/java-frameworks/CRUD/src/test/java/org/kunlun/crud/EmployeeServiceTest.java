/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.kunlun.crud;


import org.junit.Test;

import org.kunlun.crud.pojo.Department;
import org.kunlun.crud.pojo.Employee;
import org.kunlun.crud.pojo.Gender;
import org.kunlun.crud.service.EmployeeService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class EmployeeServiceTest {

    public EmployeeService getEmployeeService() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        return context.getBean("employeeService",
                EmployeeService.class);
    }
    @Test
    public void testGetEmployeeById() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        EmployeeService empService = context.getBean("employeeService",
                EmployeeService.class);
        Employee employee = empService.getEmployeeById(2);
        System.out.println(employee);
    }

    @Test
    public void testgetEmployeeByName() {
        EmployeeService empService = getEmployeeService();
        Employee employee = empService.getEmployeeByName("胡适");
        System.out.println(employee);
    }

    @Test
    public void testListEmployeesByName() {
        EmployeeService empService = getEmployeeService();
        List<Employee> empList = empService.listEmployeesByName("l");
        empList.forEach(System.out::println);
    }

    @Test
    public void testListEmployees() {
        EmployeeService empService = getEmployeeService();
        long start = System.currentTimeMillis();
        List<Employee> empList = empService.listEmployees();
        long end = System.currentTimeMillis();
        empList.forEach(System.out::println);
        System.out.println("Query total time: " + (end - start));
    }

    // @Test
    // public void testListEmployeesWithDepartment() {
    //     EmployeeService empService = getEmployeeService();
    //     long start = System.currentTimeMillis();
    //     List<Employee> empList = empService.listEmployeesWithDepartment();
    //     long end = System.currentTimeMillis();
    //     empList.forEach(System.out::println);
    //     System.out.println("Query total time: " + (end - start));
    // }

    @Test
    public void testInsertEmployee() {
        EmployeeService empService = getEmployeeService();
        Department department = new Department();
        department.setDeptId(6);
        Employee employee = new Employee("列夫・托尔其泰", Gender.MALE,
                "lev@163.com", department);
        empService.insertEmployee(employee);
    }

    @Test
    public void testUpdateEmployee() {
        EmployeeService empService = getEmployeeService();
        Employee employee = new Employee();
        employee.setEmpId(6);
        employee.setEmpName("jack");
        employee.setGender(Gender.FEMALE);
        employee.setEmail("lucy@qq.com");
        empService.updateEmployee(employee);
    }

    @Test
    public void testDeleteEmployee() {
        EmployeeService empService = getEmployeeService();
        empService.deleteEmployee(6);
    }

    @Test
    public void testDeleteEmployeeBatch() {
        EmployeeService empService = getEmployeeService();
        Integer[] empIds = {39, 40};
        empService.deleteEmployeeBatch(empIds);
    }
}
