/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package qqzone.service;

import qqzone.pojo.Reply;
import qqzone.pojo.Topic;
import qqzone.pojo.UserBasic;

import java.util.List;


public interface ReplyService {

    /**
     * 通过日志获取回复
     *
     * @param topicId 日志id
     * @return
     */
    List<Reply> getReplyListByTopicId(Integer topicId);

    /**
     * 通过id获取回复
     *
     * @param id
     * @return
     */
    Reply getReplyById(Integer id);

    /**
     * 添加日志回复
     *
     * @param reply 日志回复
     */
    void addReply(Reply reply);

    /**
     * 根据id删除指定回复
     *
     * @param id
     */
    void deleteReply(Integer id);

    /**
     * 删除指定日志关联的回复
     *
     * @param topic
     */
    void deleteReplyList(Topic topic);

}
