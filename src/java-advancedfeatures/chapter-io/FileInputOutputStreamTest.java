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

/**
 * 
 */
public class FileInputOutputStreamTest {

    public static void testFileInputStream() {
        FileInputStream fis = null;
        try {
            // 1. 实例化文件
            File file = new File("hello.txt");

            // 2. 实例化流
            fis = new FileInputStream(file);

            // 3. 读入数据
            byte[] buffer = new byte[5];
            int length;
            while ((length = fis.read(buffer)) != -1) {
                String str = new String(buffer, 0, length);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void testFileInputOutputStream() {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            // 1. 实例化文件
            File srcFile = new File("java.jpg");
            File destFile = new File("java_copy.jpg");

            // 2. 实例化流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            // 3. 处理数据
            byte[] buffer = new byte[5];
            int length;
            while ((length = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, length);
            }
            System.out.println("复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 关闭流
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 文件复制
     * 
     * @param srcPath 源文件
     * @param destPath 目的文件
     */
    public static void copyFile(String srcPath, String destPath) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            // 1. 实例化文件
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            // 2. 实例化流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            // 3. 处理数据
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, length);
            }
            System.out.println("复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 关闭流
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        // testFileInputStream();
        // testFileInputOutputStream();

        long startTime = System.currentTimeMillis();

        String srcPath = "/home/szhxiao/TheSpringFestival.mp4";
        String destPath = "TheSpringFestival_copy.mp4";
        copyFile(srcPath, destPath);

        long endTime = System.currentTimeMillis();
        System.out.println("Copy time: " + (endTime - startTime) + "ms");
    }
}

/**
 * Copy time: 103ms
 */