 /**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

 package qqzone.dao;

import qqzone.pojo.Topic;
import qqzone.pojo.UserBasic;

import java.util.List;

 /**
  *
  */
 public interface TopicDAO {
     /**
      * 获取用户日志列表
      *
      * @param userBasic 用户信息
      * @return 日志列表
      */
     List<Topic> getTopicList(UserBasic userBasic);

     /**
      * 添加日志
      *
      * @param topic 日志信息
      */
     void addTopic(Topic topic);

     /**
      * 通过ID删除日志
      *
      * @param id 日志id
      */
     void deleteTopic(Integer id);

     /**
      * 获取指定日志信息
      *
      * @param id 日志id
      * @return 日志信息
      */
     Topic getTopicById(Integer id);

 }
