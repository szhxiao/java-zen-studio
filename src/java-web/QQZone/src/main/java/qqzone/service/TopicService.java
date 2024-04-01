/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package qqzone.service;

import qqzone.pojo.Topic;
import qqzone.pojo.UserBasic;

import java.util.List;


public interface TopicService {

    /**
     * 获取用户日志列表
     *
     * @param userBasic 用户信息
     * @return 用户日志列表
     */
    List<Topic> getTopicList(UserBasic userBasic);

    /**
     * 根据id获取指定Topic，包含关联的作者信息
     * @param id
     * @return
     */
    Topic getTopic(Integer id);

    /**
     * 根据id获取日志
     *
     * @param id
     * @return
     */
    Topic getTopicById(Integer id);

    /**
     * 删除指定Topic
     *
     * @param id
     */
    void deleteTopic(Integer id);

    void addTopic(Topic topic);
}
