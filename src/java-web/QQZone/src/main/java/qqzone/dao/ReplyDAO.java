 /**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

 package qqzone.dao;

import qqzone.pojo.Reply;
import qqzone.pojo.Topic;

import java.util.List;

 /**
  *
  */
 public interface ReplyDAO {
     /**
      * 获取指定日志回复列表
      *
      * @param topic 日志
      * @return 回复列表
      */
     List<Reply> getReplyList(Topic topic);

     /**
      * 根据id获取回复
      *
      * @param id
      * @return
      */
     Reply getReply(Integer id);

     /**
      * 添加回复
      *
      * @param reply 回复
      */
     void addReply(Reply reply);

     /**
      * 根据id删除回复
      *
      * @param id
      */
     void deleteReply(Integer id);

 }
