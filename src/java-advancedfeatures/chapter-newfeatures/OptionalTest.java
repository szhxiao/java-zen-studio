/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.util.Optional;

/**
 * 
 */
public class OptionalTest {

    public static void test1() {
        Girl girl = new Girl();
        Optional<Girl> optional = Optional.of(girl);
        System.out.println(optional);
    }

    public static void test2() {
        Girl girl = new Girl("Jenny");
        // girl = null;
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        System.out.println(optionalGirl);
        Girl newGirl = optionalGirl.orElse(new Girl("Jerry"));
        System.out.println(newGirl);
    }
    
    public static void main(String[] args) {
        test2();
    }    
}
