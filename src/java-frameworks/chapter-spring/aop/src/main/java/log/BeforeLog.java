/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class BeforeLog implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println(target.getClass().getName() + " -> " + method.getName() + " is running");
    }
}
