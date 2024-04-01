/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package qqzone.pojo;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class UserBasic {

    @NonNull
    private Integer id;
    private String loginId;
    private String nickName;
    private String password;
    private String headImg;

    private UserDetail userDetail;  // 1:1
    private List<Topic> topicList;  // 1:N
    private List<UserBasic> friendList; // M:N

}
