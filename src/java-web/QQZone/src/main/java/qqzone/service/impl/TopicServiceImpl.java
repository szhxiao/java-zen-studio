/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package qqzone.service.impl;

import qqzone.dao.TopicDAO;
import qqzone.dao.UserBasicDAO;
import qqzone.pojo.Reply;
import qqzone.pojo.Topic;
import qqzone.pojo.UserBasic;
import qqzone.service.ReplyService;
import qqzone.service.TopicService;
import qqzone.service.UserBasicService;

import java.util.ArrayList;
import java.util.List;

public class TopicServiceImpl implements TopicService {
    private TopicDAO topicDAO;
    private ReplyService replyService;
    private UserBasicService userBasicService;

    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {
        return topicDAO.getTopicList(userBasic);
    }

    @Override
    public Topic getTopicById(Integer id) {
        Topic topic = getTopic(id);
        List<Reply> replyList =
                replyService.getReplyListByTopicId(topic.getId());
        topic.setReplyList(replyList);
        return topic;
    }

    @Override
    public void deleteTopic(Integer id) {
        Topic topic = topicDAO.getTopicById(id);
        if (topic != null) {
            replyService.deleteReplyList(topic);
            topicDAO.deleteTopic(id);
        }
    }

    @Override
    public void addTopic(Topic topic) {
        topicDAO.addTopic(topic);
    }

    @Override
    public Topic getTopic(Integer id) {
        Topic topic = topicDAO.getTopicById(id);
        UserBasic author = topic.getAuthor();
        author = userBasicService.getUserBasicById(author.getId());
        topic.setAuthor(author);
        return topic;
    }
}
