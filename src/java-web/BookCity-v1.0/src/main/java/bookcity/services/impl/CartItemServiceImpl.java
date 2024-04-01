 /**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

 package bookcity.services.impl;


 import bookcity.dao.CartItemDAO;
 import bookcity.pojo.Book;
 import bookcity.pojo.Cart;
 import bookcity.pojo.CartItem;
 import bookcity.pojo.User;
 import bookcity.services.BookService;
 import bookcity.services.CartItemService;

 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;

 /**
  *
  */
 public class CartItemServiceImpl implements CartItemService {
     private CartItemDAO cartItemDAO;
     private BookService bookService;

     @Override
     public void addCartItem(CartItem cartItem) {
        cartItemDAO.addCartItem(cartItem);
     }

     @Override
     public void updateCartItem(CartItem cartItem) {
        cartItemDAO.updateCartItem(cartItem);
     }

     @Override
     public void addOrUpdateCartItem(CartItem cartItem, Cart cart) {
//         System.out.println(cartItem);
         // 判断当前用户购物车是否有这本书
         if (cart != null) {
             Map<Integer, CartItem> cartItemMap = cart.getCartItemMap();
             if (cartItemMap == null) {
                 cartItemMap = new HashMap<>();
             }

             if (cartItemMap.containsKey(cartItem.getBook().getId())) {
                 CartItem cartItemTemp =
                         cartItemMap.get(cartItem.getBook().getId());
                 cartItemTemp.setBuyCount(cartItemTemp.getBuyCount() + 1);
                 updateCartItem(cartItemTemp);
             } else {
                 addCartItem(cartItem);
             }
         } else {
             addCartItem(cartItem);
         }
        System.out.println(cart);
     }

     @Override
     public List<CartItem> getCartItemList(User user) {
         List<CartItem> cartItemList = cartItemDAO.getCartItemList(user);
        for (CartItem cartItem : cartItemList) {
            Book book = bookService.getBook(cartItem.getBook().getId());
            cartItem.setBook(book);
        }
        return cartItemList;
     }

     @Override
     public Cart getCart(User user) {
         List<CartItem> cartItemList = getCartItemList(user);
         Map<Integer, CartItem> cartItemMap = new HashMap<>();
         for (CartItem cartItem : cartItemList) {
             cartItemMap.put(cartItem.getBook().getId(), cartItem);
         }
         Cart cart = new Cart();
         cart.setCartItemMap(cartItemMap);
         return cart;
     }
 }
