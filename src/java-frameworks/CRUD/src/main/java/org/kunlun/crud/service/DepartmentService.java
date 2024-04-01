/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.kunlun.crud.service;

import org.kunlun.crud.dao.DepartmentMapper;

import org.kunlun.crud.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper deptMapper;

    public Department getDepartmentById(Integer deptId){
        return deptMapper.getDepartmentById(deptId);
    }

    public List<Department> listDepartmentsByName(String deptName){
        return deptMapper.listDepartmentsByName("%" + deptName + "%");
    }

    public List<Department> listDepartments() {
        return deptMapper.listDepartments();
    }

    public void insertDepartment(Department department) {
        deptMapper.insertDepartment(department);
        System.out.println("Notes: department insert done");
    }

    public void updateDepartment(Department department) {
        deptMapper.updateDepartment(department);
        System.out.println("Notes: department update done");
    }

    public void deleteDepartment(Integer deptId) {
        deptMapper.deleteDepartment(deptId);
        System.out.println("Notes: department delete done");
    }
}
