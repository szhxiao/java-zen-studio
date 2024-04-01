/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 定义ManKind类
 */

public class KidsTest {
    
    public static void main(String[] args) {
        Kids kid = new Kids(12);
        kid.printAge();

        kid.setGender('F');
        kid.setSalary(0);

        kid.manOrWoman();
        kid.employeed();
    }    
}

