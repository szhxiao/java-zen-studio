/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package dao;

import pojo.User;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserMapperTest {

    private static final Logger logger = LoggerFactory.getLogger(UserMapperTest.class);
    private SqlSession sqlSession = null;
    private UserMapper userMapper = null;


    @BeforeAll
    public void getConnection() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void testGetAllUsers() {
        List<User> userList = userMapper.getAllUsers();
        logger.info(userList.toString());
    }

    @Test
    public void testGetUserByConditionIf() {
        // User user = new User();
        // user.setId(8);
        // user.setUname("%陈%");
        // user.setPassword("chenduxiu");
        // user.setEmail("chenduxiu@163.com");
        Map<String, Object> conditions = new HashMap<>();
        conditions.put("uname", "%余%");
        List<User> userList = userMapper.getUserByConditionIf(conditions);
        logger.info(userList.toString());
    }

    @Test
    public void testGetUserByConditionTrim() {

        // User user = new User();
        // user.setId(8);
        // user.setUname("%陈%");
        // user.setPassword("chenduxiu");
        // user.setEmail("chenduxiu@163.com");
        Map<String, Object> conditions = new HashMap<>();
        conditions.put("uname", "%路%");
        List<User> userList = userMapper.getUserByConditionTrim(conditions);
        logger.info(userList.toString());
    }

    @Test
    public void testGetUserByConditionChoose() {

        // User user = new User();
        // user.setId(8);
        // user.setUname("%陈%");
        // user.setPassword("chenduxiu");
        // user.setEmail("chenduxiu@163.com");
        Map<String, Object> conditions = new HashMap<>();
        List<User> userList = userMapper.getUserByConditionChoose(conditions);
        // userList.forEach(System.out::println);
        logger.info(userList.toString());
    }

    @Test
    public void testGetUserByConditionForeach()  {
            List<User> userList =userMapper.getUserByConditionForeach(Arrays.asList(1, 2, 5, 6));
            // userList.forEach(System.out::println);
        logger.info(userList.toString());
    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setId(1);
        user.setUname("王国维");
        // user.setPassword("chenduxiu");
        // user.setEmail("chenduxiu@163.com");
        userMapper.updateUser(user);

        sqlSession.commit();
        // userList.forEach(System.out::println);

    }

    @Test
    public void testaddUsers() {
        User user1 = new User("矛盾", "maodun", "maodun@126.com");
        User user2 = new User("路遥", "luyao", "luyao@163.com");
        User user3 = new User("余华", "yuhua", "yuhua@126.com");

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        userMapper.addUsers(userList);
        sqlSession.commit();
        // userList.forEach(System.out::println);
    }

    @Test
    public void testGetUserByInnerParameter() {
        // User user = new User();
        // user.setUname("%陈%");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("uname", "%ka%");
        List<User> userList = userMapper.getUserByInnerParameter(parameters);
        // userList.forEach(System.out::println);
        logger.info(userList.toString());
    }

    @AfterAll
    public void closeSqlSession() {
        sqlSession.close();
    }
}
