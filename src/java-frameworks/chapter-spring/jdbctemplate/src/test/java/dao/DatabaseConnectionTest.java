/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package dao;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DatabaseConnectionTest {
    private ApplicationContext context;

    @BeforeAll
    public void getApplicationContext() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void testDatabaseConnection() {
        DataSource dataSource = context.getBean("dataSource", com.alibaba.druid.pool.DruidDataSource.class);
        System.out.println(dataSource);
    }

    @Test
    public void testJdbcTemplate() {
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate",JdbcTemplate.class);
        System.out.println(jdbcTemplate);
    }
}
