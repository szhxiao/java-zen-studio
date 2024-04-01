/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package qqzone.pojo;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class Topic {

    @NonNull
    private Integer id;
    private String title;
    private String content;
    private LocalDateTime topicDate;
    private UserBasic author;   // M:1

    private List<Reply> replyList;

    public Topic(String title, String content,
                 LocalDateTime topicDate, UserBasic author) {
        this.title = title;
        this.content = content;
        this.topicDate = topicDate;
        this.author = author;
    }
}
