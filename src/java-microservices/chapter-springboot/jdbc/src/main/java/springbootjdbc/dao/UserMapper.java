/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package springbootjdbc.dao;

import org.apache.ibatis.annotations.*;
import springbootjdbc.pojo.User;

import java.util.List;

/**
 * MyBatis mapper.xml
 */
@Mapper
public interface UserMapper {

    List<User> getAllUsers();

    // @Select("SELECT `pk_id` id, `uk_uname` uname, `password`, `email` FROM `user` WHERE pk_id=#{id}")
    User getUserById(Integer id);

    // @Delete("DELETE FROM `user` WHERE pk_id=#{id}")
    void deleteUser(Integer id);

    // @Insert("INSERT INTO `user` (`pk_id`, `uk_uname`, `password`, `email`) VALUES (0, #{uname}, #{password}, #{email})")
    void insertUser(User user);

    // @Update("UPDATE `user` SET uk_uname=#{uname}, password=#{password}, email=#{email} WHERE pk_id=#{id}")
    void updateUser(User user);
}
