 /**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

 package bookcity.dao;

 import bookcity.pojo.CartItem;
 import bookcity.pojo.User;

 import java.util.List;

 /**
  *
  */
 public interface CartItemDAO {

     /**
      * 添加购物车项
      *
      * @param cartItem
      */
     void addCartItem(CartItem cartItem);

     /**
      * 更新购物车项
      * @param cartItem
      */
     void updateCartItem(CartItem cartItem);

     /**
      * 获取指定用户购物车项
      *
      * @param user 用户
      * @return
      */
     List<CartItem> getCartItemList(User user);

     /**
      * 删除购物车项
      *
      * @param cartItem
      */
     void deleteCartItem(CartItem cartItem);
 }
