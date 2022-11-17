/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.io.*;
import java.sql.*;

/**
 * 使用PreparedStatement操作Blob类型数据
 */
public class BlobTest {
    /**
     * 插入Blob类型数据
     */
    public static void testInsertBlob() {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = JDBCUtils.getConnection();
            String sqlInsert = "INSERT INTO customers (name, email, birth, photo) VALUES (?,?,?,?)";

            ps = conn.prepareStatement(sqlInsert);

            ps.setObject(1, "林纳斯・托瓦斯");
            ps.setObject(2, "linus@163.com");
            ps.setObject(3, "1975-09-11");
            FileInputStream fis = new FileInputStream(new File("src/chapter_13/kirin.png"));
            ps.setBlob(4, fis);

            ps.execute();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps);
        }
    }

    public static void testQueryBlob() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        InputStream is = null;
        FileOutputStream fos = null;

        try {
            conn = JDBCUtils.getConnection();
            String sqlQuery = "SELECT id, name, email, birth, photo FROM customers c WHERE id=?";
            ps = conn.prepareStatement(sqlQuery);

            ps.setObject(1, 14);

            rs = ps.executeQuery();
            if (rs.next()) {
//                int id = rs.getInt(1);
//                String name = rs.getString(2);
//                String email = rs.getString(3);
//                Date birth = rs.getDate(4);
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date birth = rs.getDate("birth");

                Customer customer = new Customer(id, name, email, birth);

                // 将Blob类型字段下载，以文件方式保存在本地
                Blob photo = rs.getBlob("photo");
                is = photo.getBinaryStream();
                fos = new FileOutputStream("src/chapter_13/photo.jpg");
                byte[] buffer = new byte[1024];
                int len;
                while ((len = is.read(buffer)) != -1) {
                    fos.write(buffer, 0, len);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
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

            JDBCUtils.closeResource(conn, ps, rs);
        }
    }
    
    public static void main(String[] args) {
        testQueryBlob();
    }    
}
