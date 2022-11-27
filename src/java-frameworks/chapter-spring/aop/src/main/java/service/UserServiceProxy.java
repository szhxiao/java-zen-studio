/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 增强类
 */
@Component
// 生成代理对象
@Aspect
// @Order(3)
public class UserServiceProxy {
    public UserServiceProxy() {
        System.out.println("UserServiceProxy Constructor...");
    }

    /**
     * 前置通知
     */
    @Before(value = "execution(* service.UserService.*(..))")
    public void before() {
        System.out.println("UserServiceProxy -> before pointcut ...");
    }

    @AfterReturning(value = "execution(* service.UserService.*(..))")
    public void afterReturning() {
        System.out.println("UserServiceProxy -> after returning...");
    }

    /**
     * 异常通知
     */
    @AfterThrowing(value = "execution(* service.UserService.add(..))")
    public void afterThrowing() {
        System.out.println("UserServiceProxy -> after throwing...");
    }

    @After(value = "execution(* service.UserService.add(..))")
    public void after() {
        System.out.println("UserServiceProxy -> after pointcut...");
    }

    @Around(value = "execution(* service.UserService.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("UserServiceProxy -> before around...");
        // 被增强方法执行
        proceedingJoinPoint.proceed();
        System.out.println("UserServiceProxy -> after around...");
    }
}
