/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.util.List;
import java.util.ArrayList;

/**
 * 
 */
public class ListRemoveTest {

    public static void listRemove() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);

        System.out.println(list);
    }

    public static void updateList(List list) {
        list.remove(2);
    }

    public static void main(String[] args) {
        listRemove();
    }
}
