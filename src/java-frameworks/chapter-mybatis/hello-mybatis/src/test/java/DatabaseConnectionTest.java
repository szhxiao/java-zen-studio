/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

import dao.UserMapper;
import pojo.User;

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
        // 1. 根据全局配置文件创建一个 SqlSessionFactory对象
        // 解析文件的每一个信息，保存在Configuration，
        // 返回包含ConfigurationDefaultSqlSession
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        // 2. 获取sqlSession实例
        // （sqlSession可执行已经映射的SQL语句，一个sqlSession代表和数据库的一次会话，用完关闭）
        // 返回SqlSession的实现类DefaultSqlSession，包含Executor和Configuration
        try(SqlSession session = sqlSessionFactory.openSession();) {
            System.out.println(session);
        }
    }

    @Test
    public void testGetUserById() throws Exception {
        // 1. 根据全局配置文件创建一个 SqlSessionFactory对象
        // 解析文件的每一个信息，保存在Configuration，
        // 返回包含ConfigurationDefaultSqlSession
        // MappedStatement代表一个增删改查操作的详细信息
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        // 2. 获取sqlSession实例
        // （sqlSession可执行已经映射的SQL语句，一个sqlSession代表和数据库的一次会话，用完关闭）
        // 返回SqlSession的实现类DefaultSqlSession，包含Executor和Configuration
        try(SqlSession session = sqlSessionFactory.openSession();) {
            // 3. 使用sql的唯一标识指定执行的sql语句（保存在sql映射文件中）
            // pojo.User user = openSession.selectOne("dao.UserMapper.xml.selectUser",1);

            // 3. 获取指定的代理对象MapperProxy
            // getMapper使用MapperProxyFactory创建一个MapperProxy的代理对象
            sqlSessionFactory.getConfiguration().addMapper(UserMapper.class);
            UserMapper mapper = session.getMapper(UserMapper.class);

            // 4. 执行增删改查操作
            // 调用DefaultSqlSession的增删改查(Executor)，
            // 会创建一个StatementHandler对象及ParameterHandler,ResultSetHandler对象
            // 调用StatementHandler的预编译参数及设置参数值，再调用增删改查方法
            // 操作结束后使用ResultSetHandler封装结果
            User user = mapper.getUserById(2);
            System.out.println(user);
        }
    }
}
