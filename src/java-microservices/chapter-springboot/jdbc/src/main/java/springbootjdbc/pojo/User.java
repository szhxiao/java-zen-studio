/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package springbootjdbc.pojo;

import org.springframework.stereotype.Component;

@Component
public class User {
    private Integer id;
    private String uname;
    private String password;
    private String email;

    public User() {
    }

    public User(String uname, String password, String email) {
        this.uname = uname;
        this.password = password;
        this.email = email;
    }

    public User(Integer id, String uname, String password, String email) {
        this.id = id;
        this.uname = uname;
        this.password = password;
        this.email = email;
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

    @Override
    public String toString() {
        return "User{" + id +
                ", " + uname +
                ", " + password +
                ", " + email +
                "}";
    }
}
