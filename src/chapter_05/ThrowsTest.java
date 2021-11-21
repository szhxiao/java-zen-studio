/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * throws
 */
public class ThrowsTest {
    public static void readFile() throws FileNotFoundException, IOException {
        File file = new File("hello.txt");
        FileInputStream fis = new FileInputStream(file);

        int data = fis.read();
        while (data != -1) {
            System.out.print((char)data);
            data = fis.read();
        }

        fis.close();
    }    

    public static void main(String[] args) {
        // main()方法调用readFile()方法，处理异常
        try {
            readFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
