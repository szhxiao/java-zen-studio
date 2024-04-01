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
public class HostReply {

    @NonNull
    private Integer id;
    private String content;
    private LocalDateTime hostReplyDate;
    private UserBasic author;   // M:1
    private Reply reply;    // 1:1

    public HostReply(String content, LocalDateTime hostReplyDate,
                     UserBasic author, Reply reply) {
        this.content = content;
        this.hostReplyDate = hostReplyDate;
        this.author = author;
        this.reply = reply;
    }
}
