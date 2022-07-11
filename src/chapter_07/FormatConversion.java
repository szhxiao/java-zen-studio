/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 
 */
public class FormatConversion {

    public static void convert(String src, String dest) {
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;

        try {
            // 1. 实例化文件
            File srcFile = new File(src);
            File destFile = new File(dest);
            // 2. 实例化流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);

            isr = new InputStreamReader(fis, "utf-8");
            osw = new OutputStreamWriter(fos, "gbk");
            // 3. 数据处理
            char[] cbuf = new char[128];
            int length;
            while ((length = isr.read(cbuf)) != -1) {
                osw.write(cbuf, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 关闭资源
            try {
                if (isr != null) {
                    isr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (osw != null) {
                    osw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        String srcPath = "livehappily.txt";
        String destPath = "livehappily_gbk.txt";
        convert(srcPath, destPath);
    }    
}
