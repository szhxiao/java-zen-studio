/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package qqzone.service;

import qqzone.pojo.HostReply;
import qqzone.pojo.Reply;

import java.util.List;


public interface HostReplyService {
    /**
     * 通过ReplyId获取主人回复
     *
     * @param replyId
     * @return
     */
    HostReply getHostReplyByReplyId(Integer replyId);

    /**
     * 删除主人回复
     *
     * @param id
     */
    void deleteHostReply(Integer id);

    /**
     * 添加主人回复
     *
     * @param hostReply
     */
    void addHostReply(HostReply hostReply);
}
