/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package restful.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restful.dao.UserDAO;
import restful.pojo.User;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    /**
     * 添加用户
     * @param user 用户
     */
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    /**
     * 修改用户
     * @param user 用户
     */
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    /**
     * 删除用户
     * @param id
     */
    public void removeUser(Integer id) {
        userDAO.removeUser(id);
    }

    /**
     * 通过id查询用户信息
     * @param id
     * @return
     */
    public User getUserById(Integer id) {
        return userDAO.getUserById(id);
    }

    /**
     * 获取表中用户数量
     * @return
     */
    public int getUserCount() {
        return userDAO.getUserCount();
    }

    /**
     * 获取所有用户信息
     * @return
     */
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    /**
     * 批量添加用户
     * @param batchArgs
     */
    public void batchSaveUsers(List<Object[]> batchArgs) {
        userDAO.batchSaveUsers(batchArgs);
    }

    /**
     * 批量修改用户
     * @param batchArgs
     */
    /* public void batchUpdateUsers(List<Object[]> batchArgs) {
        userDAO.batchUpdateUsers(batchArgs);
    } */

    /* public void batchRemoveUsers(List<Object[]> batchArgs) {
        userDAO.batchRemoveUsers(batchArgs);
    } */
}
