/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.example.dao.impl;

import org.example.dao.UserDAO;
import org.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void saveUser(User user) {
        String sql = "INSERT INTO `user` (`id`, `name`, `password`, " +
                "`address`, `phone`) VALUES (0, ?, ?, ?, ?)";
        //int update = jdbcTemplate.update(sql, user.getName(), user.getPassword(),
        //        user.getAddress(), user.getPhone());
        Object[] userArgs = {user.getName(), user.getPassword(),
                user.getAddress(), user.getPhone()};
        int update = jdbcTemplate.update(sql, userArgs);
        System.out.println("Save done, affected " + update + " rows");
    }

    @Override
    public void updateUser(User user) {
        String sql = "UPDATE `user` SET name=?, password=?, address=?, " +
                "phone=? WHERE id=?";
        Object[] userArgs = {user.getName(), user.getPassword(),
                user.getAddress(), user.getPhone(), user.getId()};
        int update = jdbcTemplate.update(sql, userArgs);
        System.out.println("Update done, affected " + update + " rows");
    }

    @Override
    public void removeUser(Integer id) {
        String sql = "DELETE FROM test.`user` WHERE id=?";
        int update = jdbcTemplate.update(sql, id);
        System.out.println("Remove done, affected " + update + " rows");
    }

    @Override
    public User getUserById(Integer id) {
        String sql = "SELECT * FROM test.`user` WHERE id = ?";
        User user = jdbcTemplate.queryForObject(sql,
                new BeanPropertyRowMapper<>(User.class), id);
        return user;
    }


    @Override
    public int getUserCount() {
        String sql = "SELECT COUNT(*) FROM test.`user`";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM test.`user`";
        List<User> userList = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(User.class));
        return userList;
    }

    @Override
    public void batchSaveUsers(List<Object[]> batchArgs) {
        String sql = "INSERT INTO `user` (`id`, `name`, `password`, " +
                "`address`, `phone`) VALUES (0, ?, ?, ?, ?)";
        int[] counts = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(counts));
    }

    @Override
    public void batchUpdateUsers(List<Object[]> batchArgs) {
        String sql = "UPDATE `user` SET name=?, password=?, address=?, " +
                "phone=? WHERE id=?";
        int[] counts = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(counts));
    }

    @Override
    public void batchRemoveUsers(List<Object[]> batchArgs) {
        String sql = "DELETE FROM test.`user` WHERE id=?";
        int[] counts = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(counts));
    }


}

