 /**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

 package qqzone.dao;

import qqzone.pojo.HostReply;
import qqzone.pojo.Reply;
import qqzone.pojo.Topic;

import java.util.List;

 /**
  *
  */
 public interface HostReplyDAO {
     /**
      * 根据replyId查询关联的HostReply
      *
      * @param replyId
      * @return
      */
     HostReply getHostReplyByReplyId(Integer replyId);

     /**
      * 删除指定的HostReply
      *
      * @param id
      */
     void deleteHostReply(Integer id);

     /**
      * 添加主人回复
      * @param hostReply
      */
     void addHostReply(HostReply hostReply);

 }
