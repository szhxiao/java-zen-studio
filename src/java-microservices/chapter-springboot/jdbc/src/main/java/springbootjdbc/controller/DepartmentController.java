/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package springbootjdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springbootjdbc.dao.DepartmentMapper;
import springbootjdbc.pojo.Department;

@RestController
public class DepartmentController {
    @Autowired
    DepartmentMapper deptMapper;

    @GetMapping("/dept/{id}")
    public Department getDepartmentById(@PathVariable("id") Integer id) {
        return deptMapper.getDepartmentById(id);
    }
}
