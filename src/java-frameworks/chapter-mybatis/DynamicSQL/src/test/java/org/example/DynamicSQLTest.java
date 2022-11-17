/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.example.dao.DynamicSQLMapper;
import org.example.pojo.User;

import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicSQLTest {
    public SqlSessionFactory getSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testGetUserByConditionIf() throws IOException {
        // 1. 获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSessionFactory();

        // 2. 获取SqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            // 3. 获取接口的实现对象
            // 将接口与xml文件绑定后，自动为接口创建一个代理对象，由代理对象执行增删改查操作
            DynamicSQLMapper mapper =
                    openSession.getMapper(DynamicSQLMapper.class);
            User user = new User();
            // user.setId(8);
            user.setUname("%陈%");
            // user.setPassword("chenduxiu");
            // user.setEmail("chenduxiu@163.com");
            List<User> userList = mapper.getUserByConditionIf(user);
            System.out.println(userList);

        } finally {
            openSession.close();
        }
    }

    @Test
    public void testGetUserByConditionTrim() throws IOException {
        // 1. 获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSessionFactory();

        // 2. 获取SqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            // 3. 获取接口的实现对象
            // 将接口与xml文件绑定后，自动为接口创建一个代理对象，由代理对象执行增删改查操作
            DynamicSQLMapper mapper =
                    openSession.getMapper(DynamicSQLMapper.class);
            User user = new User();
            user.setId(8);
            user.setUname("%陈%");
            user.setPassword("chenduxiu");
            // user.setEmail("chenduxiu@163.com");
            List<User> userList = mapper.getUserByConditionTrim(user);
            System.out.println(userList);

        } finally {
            openSession.close();
        }
    }

    @Test
    public void testGetUserByConditionChoose() throws IOException {
        // 1. 获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSessionFactory();

        // 2. 获取SqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            // 3. 获取接口的实现对象
            // 将接口与xml文件绑定后，自动为接口创建一个代理对象，由代理对象执行增删改查操作
            DynamicSQLMapper mapper =
                    openSession.getMapper(DynamicSQLMapper.class);
            User user = new User();
            // user.setId(8);
            // user.setUname("%陈%");
            // user.setPassword("chenduxiu");
            // user.setEmail("chenduxiu@163.com");
            List<User> userList = mapper.getUserByConditionChoose(user);
            userList.forEach(System.out::println);
        } finally {
            openSession.close();
        }
    }

    @Test
    public void testGetUserByConditionForeach() throws IOException {
        // 1. 获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSessionFactory();

        // 2. 获取SqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            // 3. 获取接口的实现对象
            // 将接口与xml文件绑定后，自动为接口创建一个代理对象，由代理对象执行增删改查操作
            DynamicSQLMapper mapper =
                    openSession.getMapper(DynamicSQLMapper.class);

            List<User> userList =
                    mapper.getUserByConditionForeach(Arrays.asList(5, 6, 7, 8));
            userList.forEach(System.out::println);
        } finally {
            openSession.close();
        }
    }

    @Test
    public void testUpdateUser() throws IOException {
        // 1. 获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSessionFactory();

        // 2. 获取SqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            // 3. 获取接口的实现对象
            // 将接口与xml文件绑定后，自动为接口创建一个代理对象，由代理对象执行增删改查操作
            DynamicSQLMapper mapper =
                    openSession.getMapper(DynamicSQLMapper.class);
            User user = new User();
            user.setId(1);
            user.setUname("王国维");
            // user.setPassword("chenduxiu");
            // user.setEmail("chenduxiu@163.com");
            mapper.updateUser(user);

            openSession.commit();
            // userList.forEach(System.out::println);
        } finally {
            openSession.close();
        }
    }

    @Test
    public void testaddUsers() throws IOException {
        // 1. 获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSessionFactory();

        // 2. 获取SqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            // 3. 获取接口的实现对象
            // 将接口与xml文件绑定后，自动为接口创建一个代理对象，由代理对象执行增删改查操作
            DynamicSQLMapper mapper =
                    openSession.getMapper(DynamicSQLMapper.class);

            User user1 = new User("矛盾", "maodun", "maodun@126.com");
            User user2 = new User("路遥", "luyao", "luyao@163.com");
            User user3 = new User("余华", "yuhua", "yuhua@126.com");

            List<User> userList = new ArrayList<>();
            userList.add(user1);
            userList.add(user2);
            userList.add(user3);

            mapper.addUsers(userList);
            openSession.commit();
            // userList.forEach(System.out::println);
        } finally {
            openSession.close();
        }
    }

    @Test
    public void testGetUserByInnerParameter() throws IOException {
        // 1. 获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSessionFactory();

        // 2. 获取SqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            // 3. 获取接口的实现对象
            // 将接口与xml文件绑定后，自动为接口创建一个代理对象，由代理对象执行增删改查操作
            DynamicSQLMapper mapper =
                    openSession.getMapper(DynamicSQLMapper.class);

            User user = new User();
            user.setUname("%陈%");
            List<User> userList = mapper.getUserByInnerParameter(user);
            userList.forEach(System.out::println);
        } finally {
            openSession.close();
        }
    }
}
