/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package qqzone.service.impl;

import qqzone.dao.ReplyDAO;
import qqzone.dao.TopicDAO;
import qqzone.pojo.HostReply;
import qqzone.pojo.Reply;
import qqzone.pojo.Topic;
import qqzone.pojo.UserBasic;
import qqzone.service.HostReplyService;
import qqzone.service.ReplyService;
import qqzone.service.TopicService;
import qqzone.service.UserBasicService;

import java.util.List;

public class ReplyServiceImpl implements ReplyService {

    private ReplyDAO replyDAO;

    private HostReplyService hostReplyService;
    private UserBasicService userBasicService;

    @Override
    public List<Reply> getReplyListByTopicId(Integer topicId) {
        List<Reply> replyList = replyDAO.getReplyList(new Topic(topicId));
        for (int i = 0; i < replyList.size(); i++) {
            Reply reply = replyList.get(i);
            // 设置关联的author
            UserBasic author =
                    userBasicService.getUserBasicById(reply.getAuthor().getId());
            reply.setAuthor(author);
            // 设置关联的HostReply
            HostReply hostReply =
                    hostReplyService.getHostReplyByReplyId(reply.getId());
            reply.setHostReply(hostReply);
        }
        return replyList;
    }

    @Override
    public Reply getReplyById(Integer id) {
        return replyDAO.getReply(id);
    }

    @Override
    public void addReply(Reply reply) {
        replyDAO.addReply(reply);
    }

    @Override
    public void deleteReply(Integer id) {
        // 1. 根据id获取reply
        Reply reply = replyDAO.getReply(id);
        // 2. 如果reply有关联的hostReply，先删除hostReply
        if (reply != null) {
            HostReply hostReply =
                    hostReplyService.getHostReplyByReplyId(reply.getId());
            if (hostReply != null) {
                hostReplyService.deleteHostReply(hostReply.getId());
            }
        }
        // 3. 删除reply
        replyDAO.deleteReply(id);
    }

    @Override
    public void deleteReplyList(Topic topic) {
        List<Reply> replyList = replyDAO.getReplyList(topic);
        if (replyList != null) {
            for (Reply reply : replyList) {
                deleteReply(reply.getId());
            }
        }
    }
}
