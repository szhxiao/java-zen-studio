/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package bookcity.services.impl;

import bookcity.dao.UserDAO;
import bookcity.pojo.User;
import bookcity.services.UserService;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    @Override
    public User login(String uname, String password) {
        return userDAO.getUser(uname, password);
    }

    @Override
    public User getUser(String uname) {
        return userDAO.getUser(uname);
    }

    @Override
    public void regist(User user) {
        userDAO.addUser(user);
    }
}
