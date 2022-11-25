/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package dao;

import org.apache.ibatis.annotations.Param;
import pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getAllUsers();

    // List<User> getUserByConditionIf(User user);
    List<User> getUserByConditionIf(Map<String, Object> conditions);

    // List<User> getUserByConditionTrim(User user);
    List<User> getUserByConditionTrim(Map<String, Object> condition);

    // List<User> getUserByConditionChoose(User user);
    List<User> getUserByConditionChoose(Map<String, Object> condition);

    List<User> getUserByConditionForeach(@Param("ids") List<Integer> ids);

    void updateUser(User user);

    void addUsers(@Param("users") List<User> users);

    // List<User> getUserByInnerParameter(User user);
    List<User> getUserByInnerParameter(Map<String, Object> parameters);
}