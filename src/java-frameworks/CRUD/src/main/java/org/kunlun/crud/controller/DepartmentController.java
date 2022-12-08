/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.kunlun.crud.controller;

import com.github.pagehelper.PageInfo;

import org.kunlun.crud.pojo.Department;
import org.kunlun.crud.pojo.Message;
import org.kunlun.crud.service.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService deptService;

    /*
    @RequestMapping(value = "departments", method = RequestMethod.GET)
    public String listDepartments(Model model) {
        System.out.println("查询所有部门信息");
        List<Department> deptList = deptService.listDepartments();
        model.addAttribute("deptList", deptList);
        return "dept_list";
    }
    */

    @ResponseBody
    @RequestMapping(value = "departments", method = RequestMethod.GET)
    public Message listDepartments() {
        System.out.println("查询所有部门信息");
        List<Department> deptList = deptService.listDepartments();
        // PageInfo<Department> deptInfo = new PageInfo<>(deptList);
        return Message.success().add("deptInfo", deptList);
    }


}
