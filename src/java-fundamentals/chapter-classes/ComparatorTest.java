import java.util.Arrays;
import java.util.Comparator;

/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 
 */
public class ComparatorTest {

    public static void stringCompare() {
        String[] arr = new String[] {
            "young", "old", "every",
            "round", "blood", "greep"
        };

        Arrays.sort(arr, new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof String && o2 instanceof String) {
                    String str1 = (String) o1;
                    String str2 = (String) o2;
                    return -str1.compareTo(str2);
                }
                throw new RuntimeException("提示：输入的数据类型不一致");
            }
        });

        System.out.println(Arrays.toString(arr));
    }

    public static void goodsCompare() {
        Goods[] arr = new Goods[5];
        arr[0] = new Goods("LenovoMouse", 34.9);
        arr[1] = new Goods("DellMouse", 43.5);
        arr[2] = new Goods("XiaomiMouse", 20.9);
        arr[3] = new Goods("HuaweiMouse", 50.5);
        arr[4] = new Goods("HuaweiMouse", 99.9);

        Arrays.sort(arr, new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Goods && o2 instanceof Goods) {
                    Goods g1 = (Goods) o1;
                    Goods g2 = (Goods) o2;
                    if (g1.getName().equals(g2.getName())) {
                        return Double.compare(g1.getPrice(), g2.getPrice());
                    } else {
                        return g1.getName().compareTo(g2.getName());
                    }
                }
                throw new RuntimeException("提示：输入的数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        stringCompare();
        goodsCompare();
    }
}    
