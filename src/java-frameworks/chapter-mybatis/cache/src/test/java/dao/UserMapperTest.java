/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package dao;

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
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserMapperTest {
    private static final Logger logger = LoggerFactory.getLogger(UserMapperTest.class);
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
    public void testGetAllUsers(){
        List<User> userList = mapper.getAllUsers();
        logger.info(userList.toString());
    }

    @Test
    public void testGetUserById() {
        User user = mapper.getUserById(1);
        logger.info(user.toString());
        User user2 = mapper.getUserById(1);
        logger.info("user == user2: " + (user == user2));
    }

    @AfterAll
    public void closeSqlSession() {
        session.close();
    }
}
