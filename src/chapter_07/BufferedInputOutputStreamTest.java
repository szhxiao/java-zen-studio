/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 
 */
public class BufferedInputOutputStreamTest {

    public static void copyFileWithBuffered(String src, String dest) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            // 1. 实例化File对象
            File srcFile = new File(src);
            File destFile = new File(dest);

            // 2. 实例化节点流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            // 3. 实例化缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            // 4. 数据处理：读取，写入
            byte[] buffer = new byte[1024];
            int length;
            while ((length = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, length);
            }
            System.out.println("复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 5. 关闭资源：先关闭外层流，再关闭内层流
            // close bos
            try {
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            // close bis
            try {
                if (bis != null) {
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            /* 可省略
            // close fos
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            // close fis
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            */
        }

    }
    
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        String srcPath = "/home/szhxiao/TheSpringFestival.mp4";
        String destPath = "TheSpringFestival_copy.mp4";
        copyFileWithBuffered(srcPath, destPath);

        long endTime = System.currentTimeMillis();
        System.out.println("Copy time: " + (endTime - startTime) + "ms");
    }    
}

/**
 * Copy time: 44ms
 */