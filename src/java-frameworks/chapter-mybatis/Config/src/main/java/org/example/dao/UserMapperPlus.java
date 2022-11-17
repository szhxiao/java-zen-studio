/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.example.dao;

import org.example.pojo.UserPlus;

import java.util.List;

public interface UserMapperPlus {
    // UserPlus getUserById(Integer id);

    UserPlus getUserAndDepartment(Integer id);

    UserPlus getUserByIdStep(Integer id);

    List<UserPlus> getUserByDepartment(Integer deptId);

}
