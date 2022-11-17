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
    User getUserById(Integer id);

    List<User> getUsers();

    void addUser(User user);
}
