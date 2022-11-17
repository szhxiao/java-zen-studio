/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package qqzone.service;

import qqzone.pojo.UserBasic;

import java.util.List;


public interface UserBasicService {

    /**
     * 用户登录
     *
     * @param loginId 登录id
     * @param password 登录密码
     * @return
     */
    UserBasic login(String loginId, String password);

    /**
     * 获取好友列表
     *
     * @param userBasic 用户
     * @return 好友列表
     */
    List<UserBasic> getFriendList(UserBasic userBasic);

    /**
     * 根据id获取指定用户信息
     *
     * @param id 用户id
     * @return 用户信息
     */
    UserBasic getUserBasicById(Integer id);
}
