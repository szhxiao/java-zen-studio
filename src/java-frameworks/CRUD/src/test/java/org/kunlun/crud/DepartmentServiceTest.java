/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.kunlun.crud;


import org.junit.Test;
import org.kunlun.crud.pojo.Department;
import org.kunlun.crud.service.DepartmentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class DepartmentServiceTest {

    public DepartmentService getDepartmentService() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        return context.getBean("departmentService",
                DepartmentService.class);
    }
    @Test
    public void testGetDepartmentById() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        DepartmentService deptService = context.getBean("departmentService",
                DepartmentService.class);
        Department department =  deptService.getDepartmentById(2);
        System.out.println(department);
    }

    @Test
    public void testListDepartmentsByName() {
        DepartmentService deptService = getDepartmentService();
        List<Department> deptList = deptService.listDepartmentsByName("部");
        deptList.forEach(System.out::println);
    }

    @Test
    public void testListDepartments() {
        DepartmentService deptService = getDepartmentService();
        List<Department> deptList = deptService.listDepartments();
        deptList.forEach(System.out::println);
    }

    @Test
    public void testInsertDepartment() {
        DepartmentService deptService = getDepartmentService();
        Department dept = new Department("财务部");
        deptService.insertDepartment(dept);
    }

    @Test
    public void testUpdateDepartment() {
        DepartmentService deptService = getDepartmentService();
        Department dept = new Department();
        dept.setDeptId(7);
        dept.setDeptName("保障部");
        deptService.updateDepartment(dept);
    }

    @Test
    public void testDeleteDepartment() {
        DepartmentService deptService = getDepartmentService();
        deptService.deleteDepartment(7);
    }
}
