/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package qqzone.pojo;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class UserDetail {

    @NonNull
    private Integer id;
    private String realName;
    private String tel;
    private String email;
    private LocalDateTime birth;
    private String star;

}
