/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package plugins;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dao.UserMapper;
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
import pojo.User;

import java.io.InputStream;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PageHelperTest {
    private static final Logger logger = LoggerFactory.getLogger(PageHelperTest.class);
    private SqlSession session = null;
    private UserMapper userMapper = null;


    @BeforeAll
    public void getConnection() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
        userMapper = session.getMapper(UserMapper.class);
    }

    @Test
    public void testPageHelper() {
        // 使用Page对象
        Page<Object> page = PageHelper.startPage(1, 5);

        List<User> userList = userMapper.getAllUsers();

        // 使用PageInfo对象
        PageInfo<User> pageInfo = new PageInfo<>(userList, 3);

        userList.forEach(System.out::println);

        // 打印Page对象属性
        // System.out.println("当前页数：" + page.getPageNum());
        // System.out.println("总记录数：" + page.getTotal());

        // 打印PageInfo对象属性
        System.out.println("当前页数：" + pageInfo.getPageNum());
        System.out.println("总记录数：" + pageInfo.getTotal());
        System.out.println("总页数：" + pageInfo.getPages());
        System.out.println("是否为第一页：" + pageInfo.isIsFirstPage());
        System.out.println("连续显示的页码：");
        int[] pageNum = pageInfo.getNavigatepageNums();
        for (int i = 0; i < pageNum.length; i++) {
            System.out.println(pageNum[i]);
            // logger.info(pageNum[i]);
        }
    }

    @AfterAll
    public void closeSqlSession() {
        session.close();
    }
}
