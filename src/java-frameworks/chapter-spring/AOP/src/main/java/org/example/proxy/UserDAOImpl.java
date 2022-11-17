/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.example.proxy;

public class UserDAOImpl implements UserDAO {

    @Override
    public int add(int x, int y) {
        System.out.println("add()...");
        return x + y;
    }

    @Override
    public void update(String id) {
        System.out.println(id + " is updating...");
    }
}
