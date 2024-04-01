/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.kunlun.crud;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.kunlun.crud.dao.EmployeeMapper;
import org.kunlun.crud.pojo.Department;
import org.kunlun.crud.pojo.Employee;
import org.kunlun.crud.pojo.Gender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class SpringJUnitTest {

    @Autowired
    EmployeeMapper empMapper;

    @Test
    public void testGetEmployeeById() {
        Employee employee = empMapper.getEmployeeById(2);
        System.out.println(employee);
    }

    @Test
    public void testListEmployeesByName() {
        List<Employee> empList = empMapper.listEmployeesByName("l");
        empList.forEach(System.out::println);
    }

    @Test
    public void testListEmployees() {
        long start = System.currentTimeMillis();
        List<Employee> empList = empMapper.listEmployees();
        long end = System.currentTimeMillis();
        empList.forEach(System.out::println);
        System.out.println("Query total time: " + (end - start));
    }

    // @Test
    // public void testListEmployeesWithDepartment() {
    //     long start = System.currentTimeMillis();
    //     List<Employee> empList = empMapper.listEmployeesWithDepartment();
    //     long end = System.currentTimeMillis();
    //     empList.forEach(System.out::println);
    //     System.out.println("Query total time: " + (end - start));
    // }

    @Test
    public void testInsertEmployee() {
        Department department = new Department();
        department.setDeptId(2);
        Employee employee = new Employee("jack", Gender.MALE, "jack@yahu.com", department);
        empMapper.insertEmployee(employee);
    }

    @Test
    public void testUpdateEmployee() {
        Employee employee = new Employee();
        employee.setEmpId(6);
        employee.setEmpName("jack");
        employee.setGender(Gender.FEMALE);
        employee.setEmail("lucy@qq.com");
        empMapper.updateEmployee(employee);
    }

    @Test
    public void testDeleteEmployee() {
        empMapper.deleteEmployee(6);
    }
}
