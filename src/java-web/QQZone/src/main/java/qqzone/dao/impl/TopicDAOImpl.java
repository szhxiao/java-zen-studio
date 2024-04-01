/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

package qqzone.dao.impl;



import qqzone.dao.BaseDAO;
import qqzone.dao.DAOException;
import qqzone.dao.TopicDAO;
import qqzone.dao.UserBasicDAO;
import qqzone.pojo.Topic;
import qqzone.pojo.UserBasic;

import java.sql.SQLException;
import java.util.List;

/**
 * 
 */
public class TopicDAOImpl extends BaseDAO implements TopicDAO {

    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {
        String sql = "SELECT * FROM t_topic tt WHERE author = ?";
        List<Topic> topicList = null;

        try {
            topicList = queryForList(Topic.class, sql, userBasic.getId());
        } catch (Exception e) {
            e.printStackTrace();
            throw new DAOException("Exception: TopicDAOImpl getTopicList()");
        }
        return topicList;
    }

    @Override
    public void addTopic(Topic topic) {
        String sql = "INSERT  INTO `t_topic`(`id`,`title`,`content`," +
                "`topicDate`,`author`) VALUES (0,?,?,?,?);";
        try {
            update(sql, topic.getTitle(), topic.getContent(),
                    topic.getTopicDate(), topic.getAuthor().getId());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException("Exception: TopicDAOImpl addTopic()");
        }
    }

    @Override
    public void deleteTopic(Integer id) {
        String sql = "DELETE FROM t_topic tt WHERE id = ?";
        try {
            update(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException("Exception: TopicDAOImpl deleteTopic()");
        }
    }

    @Override
    public Topic getTopicById(Integer id) {
        String sql = "SELECT * FROM  t_topic tt WHERE id = ?";
        Topic topic = null;

        try {
            topic = query(Topic.class, sql, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DAOException("Exception: TopicDAOImple getTopic()");
        }
        return topic;
    }
}
