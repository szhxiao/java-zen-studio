/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 
 */
public class RandomAccessFileTest {

    public static void testReadWrite(String src, String dest) {
        RandomAccessFile reader = null;
        RandomAccessFile writer = null;

        try {
            reader = new RandomAccessFile(new File(src), "r");
            writer = new RandomAccessFile(new File(dest), "rw");

            byte[] buffer = new byte[1024];
            int length;
            while ((length = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        testReadWrite("java.jpg", "java_access.jpg");
    }    
}
