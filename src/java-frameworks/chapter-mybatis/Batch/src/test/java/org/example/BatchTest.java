/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.example;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.dao.UserMapper;
import org.example.pojo.User;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

public class BatchTest {

    public SqlSessionFactory getSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testGetUsers() throws IOException {
        // 1. 获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSessionFactory();

        // 2. 获取SqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            // 3. 获取接口的实现对象
            // 将接口与xml文件绑定后，自动为接口创建一个代理对象，由代理对象执行增删改查操作
            UserMapper mapper = openSession.getMapper(UserMapper.class);
            // 使用Page对象
            Page<Object> page = PageHelper.startPage(1, 5);

            List<User> userList = mapper.getUsers();

            // 使用PageInfo对象
            // PageInfo<User> pageInfo = new PageInfo<>(userList, 3);

            userList.forEach(System.out::println);

            // 打印Page对象属性
            // System.out.println("当前页数：" + page.getPageNum());
            // System.out.println("总记录数：" + page.getTotal());


        } finally {
            openSession.close();
        }
    }

    @Test
    public void testBatch() throws IOException {
        // 1. 获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSessionFactory();

        // 2. 获取SqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession(ExecutorType.BATCH);

        long startTime = System.currentTimeMillis();
        try {
            // 3. 获取接口的实现对象
            // 将接口与xml文件绑定后，自动为接口创建一个代理对象，由代理对象执行增删改查操作
            UserMapper mapper = openSession.getMapper(UserMapper.class);
            // 使用Page对象
            Page<Object> page = PageHelper.startPage(1, 5);

            for (int i = 0; i < 10000; i++) {
                mapper.addUser(new User(UUID.randomUUID().toString().substring(0, 10),
                        "ok",
                        UUID.randomUUID().toString().substring(0, 10).concat(
                                "@163.com")));
            }

            openSession.commit();
            long endTime = System.currentTimeMillis();
            System.out.println("Total time: " + (endTime-startTime)/1000 + "s");
        } finally {
            openSession.close();
        }
    }
}
