/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    // @Select("SELECT * FROM user")
    List<User> getAllUsers();

    // @Select("SELECT * FROM user WHERE id=#{id}")
    User getUserById(Integer id);

    // 分页查询
    // 万能的Map在参数传递中使用很多
    List<User> getUserByLimit(Map<String, Integer> map);

    Integer saveUser(User user);

    Integer updateUser(User user);

    // @Delete("DELETE FROM user WHERE id=#{id}")
    void removeUser(Integer id);
}
