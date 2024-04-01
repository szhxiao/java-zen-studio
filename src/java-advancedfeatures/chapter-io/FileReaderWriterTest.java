/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 */
public class FileReaderWriterTest {

    /**
     * 从内存读入文件并输出至控制台
     */
    public static void testFileReader() {
        FileReader fr = null;
        try {
            // 1. 实例化File类对象
            File file = new File("hello.txt");
            // 2. 实例化流
            fr = new FileReader(file);
            // 3. 数据读入
            /*
            int data = fr.read();
            while (data != -1) {
                System.out.print((char)data);
                data = fr.read();
            }
            */

            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
                for (int i = 0; i < len; i++) {
                    System.out.print(cbuf[i]);
                }  
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 关闭流
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println();
    }

    /**
     * 文件写出
     */
    public static void testFileWriter() {
        FileWriter fw = null;
        try {
            // 1. 实例化File类对象
            File file = new File("hi.txt");
            // 2. 实例化FileWriter
            fw = new FileWriter(file);
            // 3. 写出数据
            fw.write("I have a dream\n");
            fw.write("You need to have a dream");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 关闭流
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void testFileCopy() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            // 1. 实例化File类对象
            File srcFile = new File("hello.txt");
            File destFile = new File("hello_copy.txt");
            // 2. 实例化流对象
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);
            // 3. 数据读入写出
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
                fw.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 关闭资源
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        // testFileReader();
        // testFileWriter();
        testFileCopy();
    }    
}
