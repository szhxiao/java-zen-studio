 /**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

 package qqzone.dao;

import qqzone.pojo.UserBasic;

import java.util.List;

/**
 * 
 */
public interface UserBasicDAO {

    /**
     * 通过用户登录ID、密码获取用户信息
     *
     * @param loginId 登录Id
     * @param password 密码
     * @return 用户信息
     */
    UserBasic getUserBasic(String loginId, String password);

    /**
     * 通过id获取用户信息
     *
     * @param id 用户id
     * @return
     */
    UserBasic getUserBasicById(Integer id);

    /**
     * 获取用户好友列表
     *
     * @param userBasic 用户信息
     * @return 好友列表
     */
    List<UserBasic> getUserBasicList(UserBasic userBasic);

}
