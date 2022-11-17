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
import org.example.dao.CacheMapper;
import org.example.pojo.User;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CacheTest {
    public SqlSessionFactory getSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testFirstLevelCache() throws IOException {
        // 1. 获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSessionFactory();

        // 2. 获取SqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            // 3. 获取接口的实现对象
            // 将接口与xml文件绑定后，自动为接口创建一个代理对象，由代理对象执行增删改查操作
            CacheMapper mapper =
                    openSession.getMapper(CacheMapper.class);
            User user1 = mapper.getUserById(6);
            System.out.println(user1);

            User user2 = mapper.getUserById(6);
            System.out.println(user2);
            System.out.println(user1==user2);
        } finally {
            openSession.close();
        }
    }

    @Test
    public void testSecondLevelCache() throws IOException {
        // 1. 获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSessionFactory();

        // 2. 获取SqlSession对象
        SqlSession firstOpenSession = sqlSessionFactory.openSession();
        SqlSession secondOpenSession = sqlSessionFactory.openSession();

        try {
            // 3. 获取接口的实现对象
            // 将接口与xml文件绑定后，自动为接口创建一个代理对象，由代理对象执行增删改查操作
            CacheMapper firstMapper =
                    firstOpenSession.getMapper(CacheMapper.class);
            CacheMapper secondMapper =
                    secondOpenSession.getMapper(CacheMapper.class);

            User user1 = firstMapper.getUserById(6);
            System.out.println(user1);
            firstOpenSession.close();

            User user2 = secondMapper.getUserById(6);
            System.out.println(user2);
            secondOpenSession.close();

            System.out.println(user1==user2);
        } finally {
            // openSession.close();
        }
    }
}
