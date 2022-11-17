/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.example.proxy;

import java.lang.reflect.Proxy;

public class JDKProxy {

    public static void main(String[] args) {
        Class[] interfaces = {UserDAO.class};
        UserDAOImpl userDAO = new UserDAOImpl();
        UserDAO dao =
                (UserDAO) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(),
                        interfaces, new UserDAOProxy(userDAO));
        int sum = dao.add(1, 2);
        System.out.println("sum: " + sum);
    }
}