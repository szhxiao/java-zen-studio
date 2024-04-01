/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.kunlun.crud.dao;

import org.kunlun.crud.pojo.Department;
import org.kunlun.crud.pojo.Employee;

import java.util.List;

public interface DepartmentMapper {

    /**
     * 根据部门id获取部门信息
     *
     * @param deptId 部门id
     * @return
     */
    Department getDepartmentById(Integer deptId);

    /**
     * 根据部门名获取部门信息
     *
     * @param deptName
     * @return
     */
    List<Department> listDepartmentsByName(String deptName);

    /**
     * 查询所有部门信息
     *
     * @return
     */
    List<Department> listDepartments();

    /**
     * 添加部门信息
     *
     * @param department
     */
    void insertDepartment(Department department);

    /**
     * 修改部门信息
     *
     * @param department
     */
    void updateDepartment(Department department);

    /**
     * 根据部门id删除部门信息
     *
     * @param deptId
     */
    void deleteDepartment(Integer deptId);

    // Integer countEmployeeNumber(Integer deptId);
}