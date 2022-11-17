/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package bookcity.pojo;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class User {

    @NonNull
    private Integer id;
    private String uname;
    private String password;
    private String email;
    private Integer role = 0;

    private Cart cart;
    private List<OrderBean> orderList;

    public User(String uname, String password, String email, Integer role) {
        this.uname = uname;
        this.password = password;
        this.email = email;
        this.role = role;
    }
}
