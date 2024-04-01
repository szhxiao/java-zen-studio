/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package springbootcache.mapper;

import org.apache.ibatis.annotations.*;
import springbootcache.pojo.Department;

/**
 * MyBatis注解方式
 */
@Mapper
public interface DepartmentMapper {
    @Select("SELECT `pk_id` id, `uk_dept_name` deptName FROM `dept` WHERE pk_id=#{id}")
    Department getDepartmentById(Integer id);

    @Delete("DELETE FROM `dept` WHERE pk_id=#{id}")
    void deleteDepartmentById(Integer id);

    @Insert("INSERT INTO `dept` (`pk_id`, `uk_dept_name`) VALUES (0, #{deptName}")
    void insertDepartment(Department department);

    @Update("UPDATE `dept` SET uk_dept_name=#{deptName}")
    void updateDepartment(Department department);
}
