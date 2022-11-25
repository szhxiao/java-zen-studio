/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package dao;

import org.apache.ibatis.annotations.Delete;
import pojo.User;

import java.util.List;


public interface UserMapper {
    // @Select("SELECT * FROM user")
    List<User> getAllUsers();

    // @Select("SELECT * FROM user WHERE id=#{id}")
    User getUserById(Integer id);

    Integer saveUser(User user);

    Integer updateUser(User user);

    @Delete("DELETE FROM user WHERE id=#{id}")
    void removeUser(Integer id);
}
