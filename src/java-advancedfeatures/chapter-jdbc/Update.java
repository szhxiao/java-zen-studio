/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 数据库通用增删改操作
 */
public class Update {
    /**
     * 通用增删改操作
     *
     * @param sql 预编译SQL语句
     * @param args 可变参数列表
     */
    public static void update(String sql, Object ...args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 1. 获取数据库连接
            conn = JDBCUtils.getConnection();
            // 2. 预编译sql语句
            ps = conn.prepareStatement(sql);
            // 3. 填充占位符，占位符个数等于可变形参个数
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1, args[i]);
            }
            // 4. 执行操作
            ps.execute();
            System.out.println("提示：更新成功!");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // 5. 关闭资源
            JDBCUtils.closeResource(conn, ps);
        }
    }
    
    public static void main(String[] args) {
        
    }    
}
