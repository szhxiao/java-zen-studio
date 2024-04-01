/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

package qqzone.dao.impl;



import qqzone.dao.BaseDAO;
import qqzone.dao.DAOException;
import qqzone.dao.HostReplyDAO;
import qqzone.dao.ReplyDAO;
import qqzone.pojo.HostReply;
import qqzone.pojo.Reply;
import qqzone.pojo.Topic;

import java.sql.SQLException;
import java.util.List;

/**
 * 
 */
public class ReplyDAOImpl extends BaseDAO implements ReplyDAO {

    @Override
    public List<Reply> getReplyList(Topic topic) {
        String sql = "SELECT * FROM  t_reply tr WHERE topic = ?";
        List<Reply> replyList = null;

        try {
            replyList = queryForList(Reply.class, sql, topic.getId());
        } catch (Exception e) {
            e.printStackTrace();
            throw new DAOException("Exception: ReplyDAOImple getReplyList()");
        }
        return replyList;
    }

    @Override
    public Reply getReply(Integer id) {
        String sql = "SELECT * FROM  t_reply tr WHERE id = ?";
        Reply reply = null;
        try {
            reply = query(Reply.class, sql, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DAOException("Exception: ReplyDAOImpl getReply()");
        }
        return reply;
    }

    @Override
    public void addReply(Reply reply) {
        String sql = "INSERT  INTO `t_reply`(`id`,`content`,`replyDate`," +
                "`author`,`topic`) VALUES (0,?,?,?,?)";
        try {
            update(sql, reply.getContent(), reply.getReplyDate(),
                    reply.getAuthor().getId(), reply.getTopic().getId());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException("Exception: ReplyDAOImpl addReply()");
        }
    }

    @Override
    public void deleteReply(Integer id) {
        String sql = "DELETE FROM t_reply WHERE id = ?";
        try {
            update(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException("Exception: ReplyDAOImpl deleteReply()");
        }
    }
}
