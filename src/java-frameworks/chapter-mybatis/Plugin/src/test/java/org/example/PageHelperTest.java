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
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.dao.UserMapper;
import org.example.pojo.User;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PageHelperTest {

    public SqlSessionFactory getSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testPageHelper() throws IOException {
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
            }

        } finally {
            openSession.close();
        }
    }
}
