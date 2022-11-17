/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.example;


import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration("classpath:beans.xml")
@SpringJUnitConfig(locations = "classpath:beans.xml")
public class TestJUnit5 {
    public static void main( String[] args ) {
        System.out.println( "Hello Spring5!" );
    }
}
