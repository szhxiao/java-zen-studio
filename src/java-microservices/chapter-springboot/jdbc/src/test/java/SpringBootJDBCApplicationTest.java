/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
public class SpringBootJDBCApplicationTest {
    @Autowired
    DataSource dataSource;

    @Test
    public void testJDBCConnection() throws SQLException {
        System.out.println(dataSource.getClass());

        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
