package springbootcache; /**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import springbootcache.mapper.UserMapper;
import springbootcache.pojo.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
public class SpringBootCacheApplicationTest {
    @Autowired
    DataSource dataSource;

    @Autowired
    UserMapper userMapper;

    // 操作字符串
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    // 操作 k-v
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedisTemplate userRedisTemplate;

    @Test
    public void testJDBCConnection() throws SQLException {
        System.out.println(dataSource.getClass());

        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    @Test
    public void testInsertUser() {

    }

    @Test
    public void testGetUserById() {
        User user = userMapper.getUserById(1);
        System.out.println(user);
    }

    @Test
    public void testStringRedisTemplate() {
        // stringRedisTemplate.opsForValue().append("msg", "hello redis");
        // String msg = stringRedisTemplate.opsForValue().get("msg");
        // System.out.println(msg);
        stringRedisTemplate.opsForList().leftPush("reading list", "长安的荔枝");
        stringRedisTemplate.opsForList().leftPush("reading list", "心安即是归处");
        stringRedisTemplate.opsForList().leftPush("reading list", "一日三秋");
    }

    @Test
    public void testRedisTemplate() {
        User user = userMapper.getUserById(2);
        // redisTemplate.opsForValue().set("user-01", user);
        // 改变默认序列化规则
        userRedisTemplate.opsForValue().set("user-01", user);
    }
}
