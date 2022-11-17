 /**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

 package bookcity.dao;


 import bookcity.pojo.User;

 /**
  *
  */
 public interface UserDAO {

     /**
      * 通过用户名、密码获取用户
      *
      * @param uname 用户名
      * @param password 密码
      * @return
      */
     User getUser(String uname, String password);

     /**
      * 通过用户名获取用户
      *
      * @param uname 用户名
      * @return
      */
     User getUser(String uname);

     /**
      * 添加用户
      *
      * @param user
      */
     void addUser(User user);
 }
