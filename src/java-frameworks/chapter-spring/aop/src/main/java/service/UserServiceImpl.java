/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Override
    public void add() {
        System.out.println("add user");
    }

    @Override
    public void update() {
        System.out.println("update user");
    }

    @Override
    public void query() {
        System.out.println("query user");
    }

    @Override
    public void remove() {
        System.out.println("remove user");
    }
}
