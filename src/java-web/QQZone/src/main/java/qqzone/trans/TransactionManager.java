/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package trans;

import qqzone.dao.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 */
public class TransactionManager {

    /**
     * 开启事务
     */
    public static void beginTransaction() throws SQLException {
        JDBCUtils.getInstance().getConnection().setAutoCommit(false);
    }

    public static void commit() throws SQLException {
        Connection conn = JDBCUtils.getInstance().getConnection();
        conn.commit();
        JDBCUtils.getInstance().closeConnection();
    }

    public static void rollback() throws SQLException {
        Connection conn = JDBCUtils.getInstance().getConnection();
        conn.rollback();
        JDBCUtils.getInstance().closeConnection();
    }
}
