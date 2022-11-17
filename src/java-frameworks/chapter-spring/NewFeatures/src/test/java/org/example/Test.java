/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.example;


import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// 指定单元测试框架
//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class Test {
    public static void main( String[] args ) {
        System.out.println( "Hello Spring5!" );
    }
}
