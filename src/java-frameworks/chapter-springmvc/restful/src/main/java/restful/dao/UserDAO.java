/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package restful.dao;

import restful.pojo.User;

import java.util.List;

public interface UserDAO {
    /**
     * 添加用户
     * @param user 用户
     */
    void saveUser(User user);

    /**
     * 修改用户信息
     * @param user 用户
     */
    void updateUser(User user);

    /**
     * 通过id删除用户
     * @param id
     */
    void removeUser(Integer id);

    /**
     * 通过id获取用户
     * @param id
     * @return
     */
    User getUserById(Integer id);

    /**
     * 获取表中用户数量
     * @return
     */
    int getUserCount();

    /**
     * 查询所有用户信息
     * @return
     */
    List<User> getAllUsers();

    /**
     * 批量添加用户
     * @param batchArgs
     */
    void batchSaveUsers(List<Object[]> batchArgs);

    /**
     * 批量修改用户
     * @param batchArgs
     */
    // void batchUpdateUsers(List<Object[]> batchArgs);

    /**
     * 批量删除用户
     * @param batchArgs
     */
    // void batchRemoveUsers(List<Object[]> batchArgs);
}

