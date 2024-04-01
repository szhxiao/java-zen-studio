/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package pojo;

import org.apache.ibatis.type.Alias;

public class User {
    private Integer id;
    private String uname;
    private String password;
    private String email;
    private Department department;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "User{" + id +
                ", " + uname +
                ", " + password +
                ", " + email +
                ", " + department.getDepartmentName() +
                "}";
    }
}