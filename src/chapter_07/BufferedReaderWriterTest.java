/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 */
public class BufferedReaderWriterTest {
    public static void copyFileWithBuffered(String src, String dest) {
        FileReader fr = null;
        FileWriter fw = null;
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            // 1. 实例化文件
            File srcFile = new File(src);
            File destFile = new File(dest);
            // 2. 实例化字符流
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);
            // 3. 实例化缓冲流
            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);
            // 4. 数据处理
            // 方式一：
            char[] cbuf = new char[128];
            int length;
            while ((length = br.read(cbuf)) != -1) {
                bw.write(cbuf, 0, length);
            }

            // 方式二：
            // String data;
            // while ((data = br.readLine()) != null) {
            //     bw.write(data);
            //     bw.newLine();
            // }
            System.out.println("复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 5. 关闭资源
            try {
                if (br!= null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        String srcPath = "livehappily.txt";
        String destPath = "livehappily_copy.txt";
        copyFileWithBuffered(srcPath, destPath);

        long endTime = System.currentTimeMillis();
        System.out.println("Copy time: " + (endTime - startTime) + "ms");
    }    
}

/**
 * Copy time: 2ms
 */