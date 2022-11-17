/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.example.pojo;

// @Alias("user")
public class UserPlus {
    private Integer id;
    private String uname;
    private String password;
    private String email;
    private Department department;

    public UserPlus() {
    }

    public UserPlus(String uname, String password, String email) {
        this.uname = uname;
        this.password = password;
        this.email = email;
    }

    public UserPlus(String uname, String password, String email, Department department) {
        this.uname = uname;
        this.password = password;
        this.email = email;
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    // public void setId(Integer id) {
    //     this.id = id;
    // }

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
        return "UserPlus{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", department=" + department +
                '}';
    }
}
