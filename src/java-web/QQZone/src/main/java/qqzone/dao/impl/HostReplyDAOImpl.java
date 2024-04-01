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
import qqzone.pojo.HostReply;

import java.sql.SQLException;

/**
 * 
 */
public class HostReplyDAOImpl extends BaseDAO implements HostReplyDAO {

    @Override
    public HostReply getHostReplyByReplyId(Integer replyId) {
        String sql = "SELECT * FROM t_host_reply thr WHERE reply = ?";
        HostReply hostReply = null;

        try {
            hostReply = query(HostReply.class, sql, replyId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DAOException("Exception: HostReplyDAOImpl " +
                    "getHostReplyByReplyId()");
        }
        return hostReply;
    }

    @Override
    public void deleteHostReply(Integer id) {
        String sql = "DELETE FROM t_host_reply thr WHERE id = ?";
        try {
            update(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException("Exception: HostReplyDAOImpl " +
                    "deleteHostReply()");
        }
    }

    @Override
    public void addHostReply(HostReply hostReply) {
        String sql = "INSERT INTO `t_host_reply` (`id`, `content`, " +
                "`hostReplyDate`, `author`, `reply`) VALUES (0,?,?,?,?)";
        try {
            update(sql, hostReply.getContent(), hostReply.getHostReplyDate(),
                    hostReply.getAuthor().getId(), hostReply.getReply().getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
