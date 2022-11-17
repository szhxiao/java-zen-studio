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
import org.example.dao.DepartmentMapper;
import org.example.dao.UserMapper;
import org.example.dao.UserMapperAnnotation;
import org.example.dao.UserMapperPlus;
import org.example.pojo.Department;
import org.example.pojo.User;
import org.example.pojo.UserPlus;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FunctionTest {
    public SqlSessionFactory getSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testAddUser() throws IOException {
        // 1. 获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSessionFactory();

        // 2. 获取SqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            // 3. 获取接口的实现对象
            // 将接口与xml文件绑定后，自动为接口创建一个代理对象，由代理对象执行增删改查操作
            UserMapper mapper = openSession.getMapper(UserMapper.class);

            User user = new User("陈忠实","chenzhongshi", "chenzhongshi@163.com");
            mapper.addUser(user);
            System.out.println("id: " + user.getId());

            openSession.commit();
        } finally {
            openSession.close();
        }
    }

    @Test
    public void testUpdateUser() throws IOException {
        // 1. 获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSessionFactory();

        // 2. 获取SqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            // 3. 获取接口的实现对象
            // 将接口与xml文件绑定后，自动为接口创建一个代理对象，由代理对象执行增删改查操作
            UserMapper mapper = openSession.getMapper(UserMapper.class);

            User user = new User(3, "胡适","hushi", "hushi@163.com");
            mapper.updateUser(user);

            openSession.commit();
        } finally {
            openSession.close();
        }
    }

    @Test
    public void testDeleteUser() throws IOException {
        // 1. 获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSessionFactory();

        // 2. 获取SqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            // 3. 获取接口的实现对象
            // 将接口与xml文件绑定后，自动为接口创建一个代理对象，由代理对象执行增删改查操作
            UserMapper mapper = openSession.getMapper(UserMapper.class);

            mapper.deleteUser(4);

            openSession.commit();
        } finally {
            openSession.close();
        }
    }

    @Test
    public void testGetUserById() throws IOException {
        // 1. 获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSessionFactory();

        // 2. 获取SqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            // 3. 获取接口的实现对象
            // 将接口与xml文件绑定后，自动为接口创建一个代理对象，由代理对象执行增删改查操作
            UserMapper mapper = openSession.getMapper(UserMapper.class);

            User user = mapper.getUserById(6);
            System.out.println(user);
        } finally {
            openSession.close();
        }
    }

    @Test
    public void testGetUserByNameAndPassword() throws IOException {
        // 1. 获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSessionFactory();

        // 2. 获取SqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            // 3. 获取接口的实现对象
            // 将接口与xml文件绑定后，自动为接口创建一个代理对象，由代理对象执行增删改查操作
            UserMapper mapper = openSession.getMapper(UserMapper.class);

            User user = mapper.getUserByNameAndPasswords("鲁迅", "luxun");

            System.out.println(user);
        } finally {
            openSession.close();
        }
    }

    @Test
    public void testGetUserByMap() throws IOException {
        // 1. 获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSessionFactory();

        // 2. 获取SqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            // 3. 获取接口的实现对象
            // 将接口与xml文件绑定后，自动为接口创建一个代理对象，由代理对象执行增删改查操作
            UserMapper mapper = openSession.getMapper(UserMapper.class);

            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("uname", "老舍");
            paramMap.put("password", "laoshe");

            User user = mapper.getUserByMap(paramMap);

            System.out.println(user);
        } finally {
            openSession.close();
        }
    }

    @Test
    public void testGetUserByName() throws IOException {
        // 1. 获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSessionFactory();

        // 2. 获取SqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            // 3. 获取接口的实现对象
            // 将接口与xml文件绑定后，自动为接口创建一个代理对象，由代理对象执行增删改查操作
            UserMapper mapper = openSession.getMapper(UserMapper.class);

            List<User> userList = mapper.getUserByName("%陈%");

            for (User user : userList) {
                System.out.println(user);
            }
        } finally {
            openSession.close();
        }
    }

    @Test
    public void testGetUserByIdReturnedMap() throws IOException {
        // 1. 获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSessionFactory();

        // 2. 获取SqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            // 3. 获取接口的实现对象
            // 将接口与xml文件绑定后，自动为接口创建一个代理对象，由代理对象执行增删改查操作
            UserMapper mapper = openSession.getMapper(UserMapper.class);

            Map<String, Object> userMap = mapper.getUserByIdReturnedMap(5);
            System.out.println(userMap);
        } finally {
            openSession.close();
        }
    }

    @Test
    public void testGetUserByNameLike() throws IOException {
        // 1. 获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSessionFactory();

        // 2. 获取SqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            // 3. 获取接口的实现对象
            // 将接口与xml文件绑定后，自动为接口创建一个代理对象，由代理对象执行增删改查操作
            UserMapper mapper = openSession.getMapper(UserMapper.class);

            Map<Integer, User> map = mapper.getUserByNameLike("%陈%");
            System.out.println(map);
        } finally {
            openSession.close();
        }
    }

    @Test
    public void testGetUserAndDepartment() throws IOException {
        // 1. 获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSessionFactory();

        // 2. 获取SqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            // 3. 获取接口的实现对象
            // 将接口与xml文件绑定后，自动为接口创建一个代理对象，由代理对象执行增删改查操作
            UserMapperPlus mapper = openSession.getMapper(UserMapperPlus.class);

            UserPlus user = mapper.getUserAndDepartment(3);
            System.out.println(user);
        } finally {
            openSession.close();
        }
    }

    @Test
    public void testGetUserByIdStep() throws IOException {
        // 1. 获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSessionFactory();

        // 2. 获取SqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            // 3. 获取接口的实现对象
            // 将接口与xml文件绑定后，自动为接口创建一个代理对象，由代理对象执行增删改查操作
            UserMapperPlus mapper = openSession.getMapper(UserMapperPlus.class);

            UserPlus user = mapper.getUserByIdStep(6);
            System.out.println(user);
        } finally {
            openSession.close();
        }
    }

    @Test
    public void getDepartmentAndUsersById() throws IOException {
        // 1. 获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSessionFactory();

        // 2. 获取SqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            // 3. 获取接口的实现对象
            // 将接口与xml文件绑定后，自动为接口创建一个代理对象，由代理对象执行增删改查操作
            DepartmentMapper mapper =
                    openSession.getMapper(DepartmentMapper.class);

            Department department = mapper.getDepartmentAndUsersById(1);
            System.out.println(department);
            System.out.println(department.getUsers());
        } finally {
            openSession.close();
        }
    }

    @Test
    public void getDepartmentAndUsersByIdStep() throws IOException {
        // 1. 获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSessionFactory();

        // 2. 获取SqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            // 3. 获取接口的实现对象
            // 将接口与xml文件绑定后，自动为接口创建一个代理对象，由代理对象执行增删改查操作
            DepartmentMapper mapper =
                    openSession.getMapper(DepartmentMapper.class);

            Department department = mapper.getDepartmentByIdStep(1);
            System.out.println(department);
            System.out.println(department.getUsers());
        } finally {
            openSession.close();
        }
    }
}
