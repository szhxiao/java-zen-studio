 /**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

 package bookcity.dao.impl;


 import myssm.dao.BaseDAO;
 import myssm.dao.DAOException;
 import bookcity.dao.UserDAO;
 import bookcity.pojo.User;

 import java.sql.SQLException;

 /**
  *
  */
 public class UserDAOImpl extends BaseDAO implements UserDAO {


     @Override
     public User getUser(String uname, String password) {
         String sql = "SELECT * FROM t_user tu WHERE `uname` = ? AND " +
                 "`password` = ?";
         User user = null;
         try {
             user = query(User.class, sql, uname, password);
         } catch (Exception e) {
             e.printStackTrace();
             throw new DAOException("Exception: UserDAOImpl getUser()");
         }
         return user;
     }

     @Override
     public User getUser(String uname) {
         String sql = "SELECT * FROM t_user tu WHERE `uname` = ?";
         User user = null;
         try {
             user = query(User.class, sql, uname);
         } catch (Exception e) {
             e.printStackTrace();
             throw new DAOException("Exception: UserDAOImpl getUser()");
         }
         return user;
     }

     @Override
     public void addUser(User user) {
        String sql = "INSERT INTO `t_user`(`id`,`uname`,`password`,`email`," +
                "`role`) VALUES (0,?,?,?,0)";
         try {
             update(sql, user.getUname(), user.getPassword(), user.getEmail());
         } catch (SQLException e) {
             e.printStackTrace();
             throw new DAOException("Exception: UserDAOImple addUser()");
         }
     }
 }
