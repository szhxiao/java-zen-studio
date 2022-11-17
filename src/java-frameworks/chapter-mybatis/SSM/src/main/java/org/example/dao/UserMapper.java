/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.example.dao;

import org.example.pojo.User;

import java.util.List;


public interface UserMapper {

    /**
     * 根据id查询用户
     *
     * @param id 用户id
     * @return
     */
    User getUserById(Integer id);

    /**
     * 查询所有用户
     *
     * @return
     */
    List<User> getUsers();

}