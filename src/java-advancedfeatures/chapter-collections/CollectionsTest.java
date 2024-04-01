/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 
 */
public class CollectionsTest {
    
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("overlap");
        list.add("perceive");
        list.add("index");
        list.add("hitherto");

        System.out.println(list);

        // reverse()
        Collections.reverse(list);
        System.out.println(list);

        // shuffle()
        Collections.shuffle(list);
        System.out.println(list);

        // sort()
        Collections.sort(list);
        System.out.println(list);

        // copy(List dest, List src)
        List dest = Arrays.asList(new Object[list.size()]);
        System.out.println(dest);
        Collections.copy(dest, list);
        System.out.println(dest);
    }    
}
