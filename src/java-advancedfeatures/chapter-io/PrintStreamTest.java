/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * 
 */
public class PrintStreamTest {
    public static void main(String[] args) {
        PrintStream ps = null;

        try {
            FileOutputStream fos = new FileOutputStream(new File("text.txt"));
            ps = new PrintStream(fos, true);
            if (ps != null) {
                System.setOut(ps);
            }

            for (int i = 0; i <= 255; i++) {
                System.out.print((char) i);
                if (i % 50 == 0) {
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }    
}
