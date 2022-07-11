/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Iterator interface
 */
public class IteratorTest {

    public static void main(String[] args) {
        Collection collection = new ArrayList();
        collection.add("gloom");
        collection.add("darkness");
        collection.add("sun");
        collection.add("morning");

        Iterator iterator = collection.iterator();

        // for (int i = 0; i < collection.size(); i++) {
        //     System.out.println(iterator.next());
        // }

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("-----------");

        for (Object object : collection) {
            System.out.println(object);
        }
    }    
}
