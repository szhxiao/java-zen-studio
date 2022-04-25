/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 */
public class ListTest {
    
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("sufficient");
        list.add("extent");
        list.add("guarantee");
        list.add("convention");

        System.out.println(list);

        // add(int index, Object ele)
        list.add(1, "comfortable");
        System.out.println(list);

        // addAll(int index, Collection eles)
        List subList = Arrays.asList("unacceptable", "suitable");
        list.addAll(2, subList);
        System.out.println(list);

        // get(int index)
        System.out.println(list.get(4));

        // int indexOf(Object obj)
        System.out.println(list.indexOf("suitable"));

        // Object remove(int index)
        list.remove(2);
        System.out.println(list);

        // subList(int fromIndex, int toIndex)
        subList = list.subList(1, 3);
        System.out.println(subList);
    }    
}
