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
import pojo.Department;
import pojo.User;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DeptMapperTest {
    private static final Logger logger = LoggerFactory.getLogger(DeptMapperTest.class);
    private SqlSession session = null;
    private DeptMapper deptMapper = null;


    @BeforeAll
    public void getConnection() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
        deptMapper = session.getMapper(DeptMapper.class);
    }

    @Test
    public void testGetAllDepartments(){
        List<Department> deptList = deptMapper.getAllDepartments();
        logger.info(deptList.toString());
    }

    @Test
    public void testGetUserById() {
        Department dept = deptMapper.getDepartmentById(3);
        logger.info(dept.toString());
    }

    @Test
    public void testGetUsersOfDepartment() {
        List<User> userList = deptMapper.getUsersOfDepartment(1);
        logger.info(userList.toString());
    }


    @AfterAll
    public void closeSqlSession() {
        session.close();
    }
}
