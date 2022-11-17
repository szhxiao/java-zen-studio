/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.pojo.User;

import java.util.List;

public interface DynamicSQLMapper {

    List<User> getUserByConditionIf(User user);

    List<User> getUserByConditionTrim(User user);

    List<User> getUserByConditionChoose(User user);

    List<User> getUserByConditionForeach(@Param("ids") List<Integer> ids);

    void updateUser(User user);

    void addUsers(@Param("users") List<User> users);

    List<User> getUserByInnerParameter(User user);
}