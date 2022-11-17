/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.example.dao;


import org.apache.ibatis.annotations.Select;
import org.example.pojo.User;


public interface UserMapperAnnotation {
    @Select("SELECT `pk_id` id, `uk_uname` uname, `password`, `email` FROM t_user WHERE  pk_id = #{pk_id}")
    public User getUserById(Integer id);
}
