
/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Collection interface
 */
public class CollectionTest {
    public static void main(String[] args) {
        Collection coll = new ArrayList();

        // add()
        coll.add("walker");
        coll.add("with");
        coll.add("sun");
        coll.add("night");
        coll.add(true);

        // size()
        System.out.println("coll.size: " + coll.size());

        // toString()
        System.out.println(coll);

        // isEmpty()
        System.out.println("coll.isEmpty: " + coll.isEmpty());

        // contains()
        boolean isContains = coll.contains("sun");
        System.out.println("coll.contains(\"sun\"): " + isContains);

        Collection subcoll = Arrays.asList("the", "sun", "morning");

        // containsAll()
        System.out.println("coll.containsAll(subcoll): " + coll.containsAll(subcoll));

        // remove()
        coll.remove(true);
        System.out.println(coll);

        // removeAll()
        coll.removeAll(subcoll);
        System.out.println(coll);

        // retainAll()
        Collection subcoll1 = Arrays.asList("afraid", "night", "walker");
        coll.retainAll(subcoll1);
        System.out.println(coll);

        // toArray()
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }    
}
