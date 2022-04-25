/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;

/**
 * 
 */
public class FileTest {
    
    public static void main(String[] args) throws IOException {

        // 相对路径：相对于当前目录
        // 绝对路径： 
        File file = new File("hello.txt");
        // 文件创建
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("创建成功");
        } else {
            file.delete();
            System.out.println("删除成功");
        }

        // 文件目录创建
        File directory = new File("./test");
        boolean mkdir = directory.mkdir();
        if (mkdir) {
            System.out.println("目录创建成功");
        } else {
            System.out.println("目录创建失败");
        }

        // 常用方法
        System.out.println("path: " + file.getAbsolutePath());
        System.out.println("name: " + file.getName());
        System.out.println("parent: " + file.getParent());
        System.out.println("length: " + file.length());
        System.out.println("lastModified: " + file.lastModified());
        System.out.println("isFile: " + file.isFile());
        System.out.println("isDirectory: " + file.isDirectory());
        System.out.println("exits: " + file.exists());
        System.out.println("canRead: " + file.canRead());
        System.out.println("canWrite: " + file.canWrite());
    }    
}
