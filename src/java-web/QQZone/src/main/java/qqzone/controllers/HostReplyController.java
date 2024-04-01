/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package qqzone.controllers;


import qqzone.pojo.HostReply;
import qqzone.pojo.Reply;
import qqzone.pojo.UserBasic;
import qqzone.service.HostReplyService;
import qqzone.service.ReplyService;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

public class HostReplyController {
    private HostReplyService hostReplyService;
    private ReplyService replyService;

    public String addHostReply(String content, Integer replyId,
                           HttpSession session) {
        UserBasic author = (UserBasic) session.getAttribute("userBasic");

        Reply reply = replyService.getReplyById(replyId);

        System.out.println("----------------");
        System.out.println("author: " + author);
        System.out.println("reply: " + reply);
        System.out.println("content: " + content);

        HostReply hostReply = new HostReply(content, LocalDateTime.now(),
                author, reply);
        System.out.println(hostReply);
        hostReplyService.addHostReply(hostReply);
        return "redirect:topic.do?operate=topicDetail&id="
                + reply.getTopic().getId();
    }
}
