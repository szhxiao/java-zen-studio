/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.example.pojo;


import lombok.*;

@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @NonNull
    private Integer id;
    private String name;
    private String password;
    private String address;
    private String phone;

    public User(String name, String password, String address, String phone) {
        this.name = name;
        this.password = password;
        this.address = address;
        this.phone = phone;
    }
}
