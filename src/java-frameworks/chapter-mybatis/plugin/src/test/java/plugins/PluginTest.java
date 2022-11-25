/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package plugins;

import dao.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pojo.User;

import java.io.InputStream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PluginTest {
    private static final Logger logger = LoggerFactory.getLogger(PluginTest.class);
    private SqlSession session = null;
    private UserMapper mapper = null;


    @BeforeAll
    public void getConnection() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
        mapper = session.getMapper(UserMapper.class);
    }

    @Test
    public void testGetUserById() {
        User user = mapper.getUserById(5);
        logger.info(user.toString());
    }

    @AfterAll
    public void closeSqlSession() {
        session.close();
    }
}
