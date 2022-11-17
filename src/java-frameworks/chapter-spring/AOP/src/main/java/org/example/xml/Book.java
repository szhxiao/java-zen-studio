/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.example.xml;

import org.springframework.stereotype.Component;

/**
 * AspectJ配置文件
 * 被增强类
 */
@Component
public class Book {
    public void buy() {
        System.out.println("add...");
    }
}
