/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.example.pojo;

public class User {
    private Integer id;
    private String username;
    private String password;
    private String address;
    private String phone;

    public User() {
    }

    public User(Integer id, String username,
                String password, String address, String phone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.address = address;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
