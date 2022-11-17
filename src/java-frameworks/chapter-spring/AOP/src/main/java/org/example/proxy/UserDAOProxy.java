/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.example.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 创建代理对象代码
 */
public class UserDAOProxy implements InvocationHandler {
    private Object handler;

    //public UserDAOProxy() {
    //}

    public UserDAOProxy(Object object) {
        handler = object;
    }

    //增强的逻辑
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        // 方法之前
        System.out.println("方法执行之前" + method.getName() + "传递的参数：" + Arrays.toString(objects));
        Object res = method.invoke(handler, objects);

        // 方法之后
        System.out.println("方法执行之后" + handler);
        return res;
    }
}