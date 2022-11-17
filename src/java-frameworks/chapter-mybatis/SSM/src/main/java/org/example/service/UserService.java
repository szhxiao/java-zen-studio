/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.example.service;


import org.example.dao.UserMapper;
import org.example.pojo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getUsers() {
        return userMapper.getUsers();
    }
}
