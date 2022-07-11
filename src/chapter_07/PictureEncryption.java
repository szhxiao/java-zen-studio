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
public class PictureEncryption {

    public static void encrypt(String src, String dest) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            // 1. 实例化文件
            File srcFile = new File(src);
            File destFile = new File(dest);
            // 2. 实例化流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            // 3. 处理数据
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) != -1) {
                for (int i = 0; i < length; i++) {
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }
                fos.write(buffer, 0, length);
            }
            System.out.println("提示：加密结束");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 关闭资源
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

    public static void decrypt(String src, String dest) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            // 1. 实例化文件
            File srcFile = new File(src);
            File destFile = new File(dest);
            // 2. 实例化流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            // 3. 处理数据
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) != -1) {
                for (int i = 0; i < length; i++) {
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }
                fos.write(buffer, 0, length);
            }
            System.out.println("提示：解密结束");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 关闭资源
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

        // String srcPath = "java.jpg";
        // String destPath = "java_encrypted.jpg";
        // encrypt(srcPath, destPath);

        String srcPath = "java_encrypted.jpg";
        String destPath = "java_decrypted.jpg";
        decrypt(srcPath, destPath);
    }    
}
