/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.example.annotation;

import org.springframework.stereotype.Component;

/**
 * AspectJ注解
 * 被增强类
 */
@Component
public class User {
    public void add() {
        System.out.println("add...");
    }
}
