/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration      // 配置类
@ComponentScan(basePackages = {"org.example"})      // 开启组件扫描
@EnableTransactionManagement        // 开启事务
public class AnnotationConfig {

    /**
     * 创建数据库连接池
     * @return 数据库连接
     */
    @Bean
    public DataSource getDataSource() {
        DataSource dataSource = new DruidDataSource();
        Properties properties = new Properties();
        InputStream is = this.getClass().getResourceAsStream(
                "/druid.properties");
        try {
            properties.load(is);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(dataSource);
        return dataSource;
    }

    /**
     * 创建JdbcTemplate对象
     *
     * @param dataSource 数据库连接池
     * @return
     */
    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    /**
     * 创建事务管理器
     *
     * @param dataSource 数据库连接池
     * @return
     */
    @Bean
    public DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }

}
