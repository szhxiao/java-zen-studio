/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.kunlun.crud;

import com.github.pagehelper.PageInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.kunlun.crud.pojo.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@EnableWebMvc
@ContextConfiguration(locations = {"classpath:applicationContext.xml",
        "classpath:springmvc.xml"})
public class EmployeeControllerTest {

    // 传入SpringMVC的IOC
    @Autowired
    WebApplicationContext context;

    // 虚拟mvc请求，获取处理结果
    // @Autowired
    MockMvc mvc;

    @Before
    public void initMockMvc() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testListEmployeesByPageHelper() throws Exception {
        // 模拟请求并获取返回值
        MvcResult result =
                mvc.perform(MockMvcRequestBuilders.get("/employees").param(
                "pageNo",
                "1")).andReturn();
        // 请求成功后取出PageInfo，进行验证
        MockHttpServletRequest request = result.getRequest();
        PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
        System.out.println("当前页码：" + pageInfo.getPageNum());
        System.out.println("总页码：" + pageInfo.getPages());
        System.out.println("总记录数：" + pageInfo.getTotal());
        System.out.println("每页行数：" + pageInfo.getPageSize());
        System.out.println("是否有下一页：" + pageInfo.isHasNextPage());
        System.out.println("是否有上一页：" + pageInfo.isHasPreviousPage());
        System.out.println("页面连续显示页码");
        int[] nums = pageInfo.getNavigatepageNums();
        for (int i = 0; i <nums.length; i++) {
            System.out.print(i + "\t");
        }

        List<Employee> empList = pageInfo.getList();
        empList.forEach(System.out::println);
    }

    @Test
    public void testListEmployeesWithJSON() throws Exception {
        // 模拟请求并获取返回值
        MvcResult result =
                mvc.perform(MockMvcRequestBuilders.get("/list_employees").param(
                        "pageNum",
                        "1")).andReturn();
        // 请求成功后取出PageInfo，进行验证
        MockHttpServletRequest request = result.getRequest();
        PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
        System.out.println("当前页码：" + pageInfo.getPageNum());
        System.out.println("总页码：" + pageInfo.getPages());
        System.out.println("总记录数：" + pageInfo.getTotal());
        System.out.println("每页行数：" + pageInfo.getPageSize());
        System.out.println("是否有下一页：" + pageInfo.isHasNextPage());
        System.out.println("是否有上一页：" + pageInfo.isHasPreviousPage());
        System.out.println("页面连续显示页码");
        int[] nums = pageInfo.getNavigatepageNums();
        for (int i = 0; i <nums.length; i++) {
            System.out.print(i + "\t");
        }

        List<Employee> empList = pageInfo.getList();
        empList.forEach(System.out::println);
    }

}
