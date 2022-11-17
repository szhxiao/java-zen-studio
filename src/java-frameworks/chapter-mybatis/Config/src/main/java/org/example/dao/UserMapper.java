/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.example.dao;


import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.example.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * 1. SqlSession代表和数据库的一次会话，使用结束后必须关闭
 * 2. SqlSession和connection都是非线程安全的，每次使用都要去获取新的对象
 * 3. XxxMapper接口没有实现类，但接口与XxxMapper.xml文件绑定后，
 *    mybatis会自动为接口生成一个代理对象
 * 4. 两个重要的配置文件：
 *      mybatis全局配置文件，包含数据库连接池信息、事务管理信息等系统运行环境信息
 *      sql映射文件，保存了每一个sql语句的映射信息，
 */
public interface UserMapper {
    User getUserById(Integer id);

    Map<String, Object> getUserByIdReturnedMap(Integer id);

    @MapKey("id")
    Map<Integer, User> getUserByNameLike(String uname);

    User getUserByNameAndPasswords(
            @Param("uname") String uname, @Param("password") String password);

    User getUserByMap(Map<String, Object> paramMap);

    List<User> getUserByName(String uname);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(Integer id);

}
