/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package bookcity.dao.impl;

import myssm.dao.BaseDAO;
import bookcity.dao.CartItemDAO;
import myssm.dao.DAOException;
import bookcity.pojo.CartItem;
import bookcity.pojo.User;

import java.sql.SQLException;
import java.util.List;

/**
 *
 */
public class CartItemDAOImpl extends BaseDAO implements CartItemDAO {
    @Override
    public void addCartItem(CartItem cartItem) {
        String sql = "INSERT INTO `t_cart_item`(`id`,`book`,`buyCount`," +
                "`userBean`) VALUES (0,?,?,?)";
        try {
            update(sql, cartItem.getBook().getId(), cartItem.getBuyCount(),
                    cartItem.getUserBean().getId());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException("Exception: CartItemImpl addCartItem()");
        }
    }

    @Override
    public void updateCartItem(CartItem cartItem) {
        String sql = "UPDATE t_cart_item SET `buyCount` = ? WHERE `id` = ?";

        try {
            update(sql, cartItem.getBuyCount(), cartItem.getId());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException("Exception: CartItemImpl updateCartItem()");
        }
    }

    @Override
    public List<CartItem> getCartItemList(User user) {
        String sql = "SELECT * FROM `t_cart_item` tci WHERE `userBean` = ?";
        List<CartItem> cartItemList = null;
        try {
            cartItemList = queryForList(CartItem.class, sql, user.getId());
        } catch (Exception e) {
            e.printStackTrace();
            throw new DAOException("Exception: CartItemDAOImpl " +
                    "getCartItemList()");
        }
        return cartItemList;
    }

    @Override
    public void deleteCartItem(CartItem cartItem) {
        String sql = "DELETE FROM `t_cart_item` tci WHERE `id` =?";
        try {
            update(sql, cartItem.getId());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException(
                    "Exception: CartItemDAOImpl deleteCartItem()");
        }
    }
}
