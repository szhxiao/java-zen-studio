/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "user")
public class User {
    @Value(value = "美丽中国")
    private String name;
    @Value(value = "甘肃兰州")
    private String address;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    /**
     * @return the user's address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
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
