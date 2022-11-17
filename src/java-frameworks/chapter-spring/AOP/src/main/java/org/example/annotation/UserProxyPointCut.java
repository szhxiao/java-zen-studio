/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.example.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 增强类
 */
@Component
// 生成代理对象
@Aspect
@Order(1)
public class UserProxyPointCut {
    public UserProxyPointCut() {
        System.out.println("UserProxyPointCut...");
    }

    @Pointcut(value = "execution(* org.example.annotation.User.add(..))")
    public void point() {

    }
    /**
     * 前置通知
     */
    @Before(value = "point()")
    public void before() {
        System.out.println("before...");
    }

    @AfterReturning(value = "point()")
    public void afterReturnning() {
        System.out.println("after returnning...");
    }

    /**
     * 异常通知
     */
    @AfterThrowing(value = "point()")
    public void afterThrowing() {
        System.out.println("after throwing...");
    }

    @After(value = "point()")
    public void after() {
        System.out.println("after...");
    }

    @Around(value = "point()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("before around...");
        // 被增强方法执行
        proceedingJoinPoint.proceed();
        System.out.println("after around...");
    }
}
