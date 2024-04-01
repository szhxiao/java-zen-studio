/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "user")
public class User {
    @Value(value = "美丽中国")
    private String name;
    @Value(value = "甘肃兰州")
    private String address;

    public User() {
        System.out.println("User constructor...");
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
