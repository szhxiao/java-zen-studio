/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.util.Iterator;
import java.util.TreeSet;

/**
 * 
 */
public class EmployeeTest {
    
    public static void main(String[] args) {
        TreeSet set = new TreeSet();

        Employee e1 = new Employee("Linus Torvalds", 53, new MyDate(1969, (byte)12, (byte)8));
        Employee e2 = new Employee("Bill Gates", 67, new MyDate(1955, (byte)10, (byte)28));
        Employee e3 = new Employee("James Gosling", 67, new MyDate(1955, (byte)5, (byte)19));
        Employee e4 = new Employee("Dennis Ritchie", 70, new MyDate(1941, (byte)9, (byte)9));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }    
}
