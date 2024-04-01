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
import pojo.Blog;

import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BlogMapperTest {
    private static final Logger logger = LoggerFactory.getLogger(BlogMapperTest.class);
    private SqlSession sqlSession = null;
    private BlogMapper blogMapper = null;


    @BeforeAll
    public void getConnection() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        blogMapper = sqlSession.getMapper(BlogMapper.class);
    }

    @Test
    public void testSaveBlog() {
        Blog blog = new Blog();
        blog.setId(4);
        blog.setTitle("Java Frameworks");
        blog.setAuthor("yaoguang");
        blog.setCreateTime("2022-10-25");
        blog.setViews(314);

        blogMapper.saveBlog(blog);
        sqlSession.commit();
    }

    @Test
    public void testGetAllBlogs() {
        List<Blog> blogList = blogMapper.getAllBlogs();
        logger.info(blogList.toString());
    }

    @Test
    public void testGetBlogByConditions() {
        Map<String, Object> conditions = new HashMap<>();
        conditions.put("author", "yaoguang");
        conditions.put("title", "Java Fundamentals");
        List<Blog> blogList = blogMapper.getBlogByConditions(conditions);
        logger.info(blogList.toString());
    }

    @Test
    public void testUpdateBlog() {
        Map<String, Object> conditions = new HashMap<>();
        conditions.put("author", "kaiyang");
        conditions.put("views", 1314);
        conditions.put("id", "3");
        blogMapper.updateBlog(conditions);
        Blog blog = blogMapper.getBlogById(3);
        logger.info(blog.toString());
    }


    @AfterAll
    public void closeSqlSession() {
        sqlSession.close();
    }
}
