/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package dao;


import org.springframework.beans.factory.annotation.Autowired;
import pojo.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;

// @Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void saveUser(User user) {
        String sql = "INSERT INTO `user` (`pk_id`, `uk_uname`, `password`, `email`) VALUES (0, ?, ?, ?)";
        //int update = jdbcTemplate.update(sql, user.getName(), user.getPassword(),
        //        user.getAddress(), user.getPhone());
        Object[] userArgs = {user.getUname(), user.getPassword(), user.getEmail()};
        int update = jdbcTemplate.update(sql, userArgs);
        System.out.println("Save done, affected " + update + " rows");
    }

    @Override
    public void updateUser(User user) {
        String sql = "UPDATE `user` SET uk_uname=?, password=?, email=? WHERE pk_id=?";
        Object[] userArgs = {user.getUname(), user.getPassword(), user.getEmail(), user.getId()};
        int update = jdbcTemplate.update(sql, userArgs);
        System.out.println("Update done, affected " + update + " rows");
    }

    @Override
    public void removeUser(Integer id) {
        String sql = "DELETE FROM `user` WHERE pk_id=?";
        int update = jdbcTemplate.update(sql, id);
        System.out.println("Remove done, affected " + update + " rows");
    }

    @Override
    public User getUserById(Integer id) {
        String sql = "SELECT `pk_id` id, `uk_uname` uname, `password`, `email` FROM `user` WHERE pk_id = ?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
        return user;
    }


    @Override
    public int getUserCount() {
        String sql = "SELECT COUNT(*) FROM `user`";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT `pk_id` id, `uk_uname` uname, `password`, `email` FROM `user`";
        List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        return userList;
    }

    @Override
    public void batchSaveUsers(List<Object[]> batchArgs) {
        String sql = "INSERT INTO `user` (`pk_id`, `uk_uname`, `password`, `email`) VALUES (0, ?, ?, ?)";
        int[] counts = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(counts));
    }

   /*
   @Override
    public void batchUpdateUsers(List<Object[]> batchArgs) {
        String sql = "UPDATE `user` SET uk_uname=?, password=?, email=? WHERE pk_id=?";
        int[] counts = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(counts));
    }
    */

    @Override
    public void batchRemoveUsers(List<Object[]> batchArgs) {
        String sql = "DELETE FROM `user` WHERE pk_id=?";
        int[] counts = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(counts));
    }
}

