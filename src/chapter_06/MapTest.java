/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 
 */
public class MapTest {
    
    public static void main(String[] args) {
        Map map = new HashMap();
        // 添加
        map.put("Linux", "Linus Torvalds");
        map.put("Windows", "Bill Gates");
        map.put("Microsoft", "Bill Gates");
        map.put( "Java", "Games Gosling");
        map.put("C", "Dennis Ritchie");
        map.put("Vue", "YouYuxi");

        System.out.println(map);

        // remove(Object key)
        Object value = map.remove("C");
        System.out.println(value);

        // get(Object key)
        System.out.println(map.get("Java") );

        System.out.println("-------------");

        // ketSet()
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("-------------");

        // values()
        Collection coll = map.values();
        for (Object object : coll) {
            System.out.println(object);
        }
    }    
}
