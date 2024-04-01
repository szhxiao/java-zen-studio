 /**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

 package bookcity.services;


 import bookcity.pojo.User;

 /**
  *
  */
 public interface UserService {

     /**
      * 用户登录
      *
      * @param uname 用户名
      * @param password 密码
      * @return
      */
     User login(String uname, String password);

     /**
      * 通过用户名查询用户
      *
      * @param uname 用户名
      * @return
      */
     User getUser(String uname);

     /**
      * 用户注册
      *
      * @param user 用户
      */
     void regist(User user);
 }
