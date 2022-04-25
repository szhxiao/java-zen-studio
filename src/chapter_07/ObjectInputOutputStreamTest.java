/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 
 */
public class ObjectInputOutputStreamTest {

    /**
     * 对象序列化
     */
    public static void testObjectOutputStream(String fileName, Person person) {
        ObjectOutputStream oos = null;

        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            oos = new ObjectOutputStream(fos);
            // oos.writeObject(new String("core java"));
            oos.writeObject(person);
            oos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 对象反序列化 
     */
    public static void testObjectInputStream(String fileName) {
        ObjectInputStream ois = null;

        try {
            FileInputStream fis = new FileInputStream(fileName);
            ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            System.out.println(obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        // testObjectOutputStream();
        Person p = new Person("James", 28, "male");
        testObjectOutputStream("person.dat", p);
        testObjectInputStream("person.dat");

    }    
}
