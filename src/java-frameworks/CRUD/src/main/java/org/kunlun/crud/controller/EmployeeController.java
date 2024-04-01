/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.kunlun.crud.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.kunlun.crud.pojo.Employee;
import org.kunlun.crud.pojo.Message;
import org.kunlun.crud.service.DepartmentService;
import org.kunlun.crud.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Validated
public class EmployeeController {

    @Autowired
    private EmployeeService empService;

    @Autowired
    private DepartmentService deptService;

    @ResponseBody
    @RequestMapping(value = "employees/{pageNum}", method = RequestMethod.GET)
    public Message listEmployees(@PathVariable("pageNum") Integer pageNum) {
        // 判断非空
        if ((pageNum == null) || (pageNum <= 0)) {
            pageNum = 1;
        }

        System.out.println("查询所有员工信息");
        System.out.println("当前页是：" + pageNum + "，显示条数是：" + 5);

        PageHelper.startPage(pageNum, 5);
        List<Employee> empList = empService.listEmployees();
        PageInfo<Employee> empInfo = new PageInfo(empList, 5);
        return Message.success().add("empInfo", empInfo);
    }

    @ResponseBody
    @RequestMapping(value = "employee/{empId}", method = RequestMethod.GET)
    public Message getEmployeeById(@PathVariable("empId") Integer empId) {
        System.out.println("查询指定员工信息");
        Employee employee = empService.getEmployeeById(empId);
        System.out.println(employee);
        return Message.success().add("emp", employee);
    }

    @ResponseBody
    @RequestMapping(value = "check_employee", method = RequestMethod.GET)
    public Message checkEmployee(@RequestParam(value = "empName",
            required = false, defaultValue = "") String empName) {
        // 判断用户名是否为合法表达式
        String regex = "(^[a-zA-Z0-9\\s_-]{3,16}$)|(^[\\u2E80-\\u9FFF]{2,5})";
        if (!empName.matches(regex)) {
            return Message.fail().add("validate_message", "用户名不合法，应是2-5位中文或3-16位英文、空格及数字的组合");
        }
        // 数据库用户名重复校验
        Employee employee = empService.getEmployeeByName(empName);

        if ( employee == null) {
            return Message.success();
        } else {
            return Message.fail().add("validate_message", "用户名已被注册，请重新选择");
        }
    }

    @ResponseBody
    @RequestMapping(value = "employee", method = RequestMethod.POST)
    public Message insertEmployee(@Valid Employee employee,
                                  BindingResult result) {
        if (result.hasErrors()) {
            // 校验失败，向浏览器返回失败，模态框中显示错误信息
            Map<String, Object> errorMap = new HashMap<>();
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError fieldError : errors) {
                System.out.println("错误字段：" + fieldError.getField());
                System.out.println("错误信息：" + fieldError.getDefaultMessage());
                System.out.println("------------------");
                errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return Message.fail().add("errorFields", errorMap);
        } else {
            empService.insertEmployee(employee);
            return Message.success();
        }
    }

    @ResponseBody
    @RequestMapping(value = "employee/{empId}", method = RequestMethod.PUT)
    public Message updateEmployee(Employee employee) {
        System.out.println("Updating Data: " + employee);
        empService.updateEmployee(employee);
        return Message.success();
    }

    @ResponseBody
    @RequestMapping(value = "employee/{empId}", method = RequestMethod.DELETE)
    public Message deleteEmployee(@PathVariable ("empId") Integer empId) {
        System.out.println("Deleting employee...");
        empService.deleteEmployee(empId);
        return Message.success();
    }

    // 批量删除
    @ResponseBody
    @RequestMapping(value = "employees/{empIds}", method = RequestMethod.DELETE)
    public Message deleteEmployee(@PathVariable ("empIds") String empIds) {
        System.out.println("Deleting employees...");
        String[] strEmpIds = empIds.split("-");
        // System.out.println(strEmpIds.toString());
        Integer[] ids = new Integer[strEmpIds.length];
        for (int i = 0; i < strEmpIds.length; i++) {
            ids[i] = Integer.parseInt(strEmpIds[i]);
        }
        empService.deleteEmployeeBatch(ids);
        return Message.success();
    }

}
