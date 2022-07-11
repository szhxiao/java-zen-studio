/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.util.Arrays;

/**
 * 
 */
public class ComparableTest {

    public static void stringCompare() {
        String[] arr = new String[] {
            "young", "old", "every",
            "round", "blood", "greep"
        };

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void goodsCompare() {
        Goods[] arr = new Goods[4];
        arr[0] = new Goods("LenovoMouse", 34);
        arr[1] = new Goods("DellMouse", 43);
        arr[2] = new Goods("XiaomiMouse", 20);
        arr[3] = new Goods("HuaweiMouse", 50);

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        stringCompare();
        goodsCompare();
    }    
}
