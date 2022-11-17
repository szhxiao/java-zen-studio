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
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisInterfaceTest {
    public SqlSessionFactory getSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }
    /**
     * 1. 根据xml配置文件（全局配置文件）创建一个 SqlSessionFactory对象，
     *    有数据源一些运行环境信息
     * 2. sql映射文件，配置了每个sql及sql的封装规则等
     * 3. sql映射文件注册在全局配置文件
     * 4. 代码
     */
    @Test
    public void testMyBatisInterface() throws IOException {
        // 1. 获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSessionFactory();

        // 2. 获取SqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            // 3. 获取接口的实现对象
            // 将接口与xml文件绑定后，自动为接口创建一个代理对象，由代理对象执行增删改查操作
            UserMapper mapper = openSession.getMapper(UserMapper.class);

            User user = mapper.getUserById(2);
            System.out.println(user);
        } finally {
            openSession.close();
        }
    }
}
