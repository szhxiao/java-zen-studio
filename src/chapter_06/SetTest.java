/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 */
public class SetTest {
    
    public static void main(String[] args) {
        Set set = new HashSet<>();
        set.add("merely");
        set.add("invest");
        set.add("manufacture");

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("------------");

        Set lset = new LinkedHashSet<>();
        lset.add("treat");
        lset.add("vanish");
        lset.add("divide");
        lset.add("split");

        for (Object object : lset) {
            System.out.println(object);
        }

        System.out.println("------------");

        Comparator comparator = new Comparator<>() {

            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof String && o2 instanceof String) {
                    String str1 = (String) o1;
                    String str2 = (String) o2;
                    return str1.length() - str2.length();
                } else {
                    throw new RuntimeException("异常：数据类型不匹配");
                }
            }
            
        };

        // TreeSet tset = new TreeSet<>();
        TreeSet tset = new TreeSet<>(comparator);
        tset.add("bother");
        tset.add("pessimistic");
        tset.add("rent");
        tset.add("harsh");
        System.out.println(tset);
    }    
}
