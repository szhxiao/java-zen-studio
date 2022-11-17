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
@Order(3)
public class UserProxy {
    public UserProxy() {
        System.out.println("UserProxy...");
    }

    /**
     * 前置通知
     */
    @Before(value = "execution(* org.example.annotation.User.add(..))")
    public void before() {
        System.out.println("before...");
    }

    @AfterReturning(value = "execution(* org.example.annotation.User.add(..))")
    public void afterReturnning() {
        System.out.println("after returnning...");
    }

    /**
     * 异常通知
     */
    @AfterThrowing(value = "execution(* org.example.annotation.User.add(..))")
    public void afterThrowing() {
        System.out.println("after throwing...");
    }

    @After(value = "execution(* org.example.annotation.User.add(..))")
    public void after() {
        System.out.println("after...");
    }

    @Around(value = "execution(* org.example.annotation.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("before around...");
        // 被增强方法执行
        proceedingJoinPoint.proceed();
        System.out.println("after around...");
    }
}
