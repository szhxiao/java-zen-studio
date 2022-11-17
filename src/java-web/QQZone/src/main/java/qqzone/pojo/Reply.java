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
public class Reply {

    @NonNull
    private Integer id;
    private String content;
    private LocalDateTime replyDate;
    private UserBasic author;
    private Topic topic;    // M:1

    private HostReply hostReply;    // 1:1

    public Reply(String content,
                 LocalDateTime replyDate, UserBasic author, Topic topic) {
        this.content = content;
        this.replyDate = replyDate;
        this.author = author;
        this.topic = topic;
    }
}
