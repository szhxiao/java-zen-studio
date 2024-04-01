/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

package qqzone.dao.impl;



import qqzone.dao.BaseDAO;
import qqzone.dao.DAOException;
import qqzone.dao.UserBasicDAO;
import qqzone.pojo.UserBasic;

import java.util.List;

/**
 * 
 */
public class UserBasicDAOImpl extends BaseDAO implements UserBasicDAO {

    @Override
    public UserBasic getUserBasic(String loginId, String password) {
        String sql = "SELECT * FROM t_user_basic tub WHERE loginId = ? AND " +
                "password =?";
        UserBasic userBasic = null;
//        System.out.println("loginId: " + loginId + ", password: " + password);
        try {
            userBasic = query(UserBasic.class, sql, loginId, password);
//            System.out.println(userBasic);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DAOException(
                    "Exception: UserBasicDAOImpl getCustomerById()");
        }
        return  userBasic;
    }

    @Override
    public UserBasic getUserBasicById(Integer id) {
        String sql = "SELECT * FROM t_user_basic tub WHERE id = ?";
        UserBasic userBasic = null;

        try {
            userBasic = query(UserBasic.class, sql, id);

        } catch (Exception e) {
            e.printStackTrace();
            throw new DAOException("Exception: UserBasicDAOImple " +
                    "getUserBasicById()");
        }
        return userBasic;
    }

    @Override
    public List<UserBasic> getUserBasicList(UserBasic userBasic) {
        String sql = "SELECT fid as 'id' FROM t_friend tf WHERE uid = ?";
        List<UserBasic> list = null;
        try {
            list = queryForList(UserBasic.class, sql, userBasic.getId());
        } catch (Exception e) {
            e.printStackTrace();
            throw new DAOException(
                    "Exception: UserBasicDAOImpl getUserBasicList()");
        }
        return list;
    }


    public static void main(String[] args) {
    }
}
