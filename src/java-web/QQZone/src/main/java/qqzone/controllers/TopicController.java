/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package qqzone.controllers;


import qqzone.pojo.Topic;
import qqzone.pojo.UserBasic;
import qqzone.service.TopicService;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

public class TopicController {
    private TopicService topicService;

    public String topicDetail(Integer id, HttpSession session) {
        Topic topic = topicService.getTopicById(id);
        session.setAttribute("topic", topic);

        return "frames/detail";
    }

    public String deleteTopic(Integer topicId, HttpSession session) {
        topicService.deleteTopic(topicId);
        return "redirect:topic.do?operate=getTopicList";
    }

    public String addTopic(String title, String content, HttpSession session) {
        UserBasic author = (UserBasic) session.getAttribute("userBasic");
        Topic topic = new Topic(title, content, LocalDateTime.now(), author);
        topicService.addTopic(topic);
        return "redirect:topic.do?operate=getTopicList";
    }

    public String getTopicList(HttpSession session) {
        UserBasic userBasic = (UserBasic) session.getAttribute("userBasic");
        List<Topic> topicList = topicService.getTopicList(userBasic);
        userBasic.setTopicList(topicList);
        session.setAttribute("friend", userBasic);
        return "frames/main";
    }
}
