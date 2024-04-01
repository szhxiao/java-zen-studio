 /**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

 package bookcity.services;


 import bookcity.pojo.Cart;
 import bookcity.pojo.CartItem;
 import bookcity.pojo.User;

 import java.util.List;

 /**
  *
  */
 public interface CartItemService {

     /**
      * 添加购物车
      * @param cartItem
      */
     void addCartItem(CartItem cartItem);

     /**
      * 更新购物车
      *
      * @param cartItem
      */
     void updateCartItem(CartItem cartItem);

     /**
      *
      * @param cartItem
      */
     void addOrUpdateCartItem(CartItem cartItem, Cart cart);

     /**
      * 获取指定用户的所有购物车项列表
      * 方法内部查询时，将book的详细信息设置进去
      *
      * @param user 用户
      * @return
      */
     List<CartItem> getCartItemList(User user);

     /**
      * 获取用户购物车项
      *
      * @param user 用户
      * @return
      */
     Cart getCart(User user);
 }
