/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class DatabaseConnectionTest {
    @Test
    public void testGetConnection() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        try(SqlSession session = sqlSessionFactory.openSession();) {
            System.out.println(session);
        }
    }
}
