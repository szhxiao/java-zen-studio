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
import qqzone.service.UserBasicService;

import javax.servlet.http.HttpSession;
import java.util.List;

public class UserController extends ViewBaseServlet {
    private UserBasicService userBasicService;
    private TopicService topicService;

    public String login(String loginId, String password, HttpSession session) {
        UserBasic userBasic = userBasicService.login(loginId, password);
        if (userBasic != null) {
            // 获取好友信息
            List<UserBasic> friendList =
                    userBasicService.getFriendList(userBasic);
            System.out.println("-----------");
            for(UserBasic u : friendList) {
                System.out.println(u);
            }
            // 获取好友信息
            List<Topic> topicList = topicService.getTopicList(userBasic);
            System.out.println("---------");
            for(Topic t : topicList) {
                System.out.println(t);
            }
            userBasic.setFriendList(friendList);
            userBasic.setTopicList(topicList);

            // userBasic保存登录者信息
            session.setAttribute("userBasic", userBasic);
            // friend保存当前进入谁的空间
            session.setAttribute("friend", userBasic);
            return "index";
        } else {
            return "login";
        }
    }

    public String friend(Integer id, HttpSession session) {
        // 根据id获取指定用户信息
        UserBasic currentFriend = userBasicService.getUserBasicById(id);

        List<Topic> topicList = topicService.getTopicList(currentFriend);
        currentFriend.setTopicList(topicList);

        session.setAttribute("friend", currentFriend);

        return "index";
    }

}
