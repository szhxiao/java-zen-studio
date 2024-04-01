/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package springbootcache.mapper;

import org.apache.ibatis.annotations.*;
import springbootcache.pojo.User;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT `pk_id` id, `uk_uname` uname, `password`, `email` FROM `user`")
    List<User> getAllUsers();

    @Select("SELECT `pk_id` id, `uk_uname` uname, `password`, `email` FROM `user` WHERE pk_id=#{id}")
    User getUserById(Integer id);

    @Select("SELECT `pk_id` id, `uk_uname` uname, `password`, `email` FROM `user` WHERE uk_uname=#{uname}")
    User getUserByUname(String uname);

    @Delete("DELETE FROM `user` WHERE pk_id=#{id}")
    void deleteUser(Integer id);

    @Insert("INSERT INTO `user` (`pk_id`, `uk_uname`, `password`, `email`) VALUES (0, #{uname}, #{password}, #{email})")
    void insertUser(User user);

    @Update("UPDATE `user` SET uk_uname=#{uname}, password=#{password}, email=#{email} WHERE pk_id=#{id}")
    void updateUser(User user);
}
