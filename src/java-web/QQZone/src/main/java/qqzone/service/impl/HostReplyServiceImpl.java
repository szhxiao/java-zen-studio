/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package qqzone.service.impl;

import qqzone.dao.HostReplyDAO;
import qqzone.dao.ReplyDAO;
import qqzone.pojo.HostReply;
import qqzone.pojo.Reply;
import qqzone.pojo.Topic;
import qqzone.service.HostReplyService;
import qqzone.service.ReplyService;

import java.util.List;

public class HostReplyServiceImpl implements HostReplyService {
    private HostReplyDAO hostReplyDAO;

    @Override
    public HostReply getHostReplyByReplyId(Integer replyId) {
        return hostReplyDAO.getHostReplyByReplyId(replyId);
    }

    @Override
    public void deleteHostReply(Integer id) {
        hostReplyDAO.deleteHostReply(id);
    }

    @Override
    public void addHostReply(HostReply hostReply) {
        hostReplyDAO.addHostReply(hostReply);
    }
}
