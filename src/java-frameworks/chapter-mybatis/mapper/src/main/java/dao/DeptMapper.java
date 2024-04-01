/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package dao;

import pojo.Department;
import pojo.User;

import java.util.List;

public interface DeptMapper {
    List<Department> getAllDepartments();
    Department getDepartmentById(Integer id);

    List<User> getUsersOfDepartment(Integer id);
}
