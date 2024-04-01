/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package log;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;
public class AfterLog implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println(method.getName() + " finished, result is " + returnValue);
    }
}
