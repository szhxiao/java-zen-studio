/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.kunlun.crud.pojo;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.UUID;


public class Employee implements Serializable {
    private static final long serialVersionUID = UUID.randomUUID().version();

    private Integer empId;

    // @Pattern(regexp = "(^[a-zA-Z0-9\\s_-]{3,16}$)|(^[\\u2E80-\\u9FFF]{2,5})",
    //         message = "后端校验提示：用户名不合法，应是2-5位中文或3-16位英文、空格及数字的组合")
    @Pattern(regexp = "(^[a-zA-Z0-9\\s_-]{3,16}$)|(^[\\u2E80-\\u9FFF]{2,5})",
            message = "后端校验提示：用户名不合法，应是2-5位中文或3-16位英文、空格及数字的组合")
    private String empName;
    private Gender gender;

    // @Email
    @Pattern(regexp = "^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$",
            message = "后端校验提示：邮箱格式不正确，如hello@163.com")
    private String email;

    private Integer deptId;
    private Department department;

    public Employee() {
    }

    public Employee(String empName, Gender gender,
                    String email, Integer deptId) {
        this.empName = empName;
        this.gender = gender;
        this.email = email;
        this.deptId = deptId;
    }

    public Employee(String empName, Gender gender,
                    String email, Department department) {
        this.empName = empName;
        this.gender = gender;
        this.email = email;
        this.department = department;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", deptId=" + deptId +
                '}';
    }
}
