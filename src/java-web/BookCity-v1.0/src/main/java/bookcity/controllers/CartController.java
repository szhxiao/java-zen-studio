/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package bookcity.controllers;


import bookcity.pojo.Book;
import bookcity.pojo.Cart;
import bookcity.pojo.CartItem;
import bookcity.pojo.User;
import bookcity.services.BookService;
import bookcity.services.CartItemService;

import javax.servlet.http.HttpSession;
import java.util.List;

public class CartController {

    private CartItemService cartItemService;

    // 加载当前用户购物车信息
    public String index(HttpSession session) {
        User currUser = (User) session.getAttribute("currUser");
        Cart cart = cartItemService.getCart(currUser);
        currUser.setCart(cart);
        session.setAttribute("currUser", currUser);

        return "cart/cart";
    }

    /**
     * 将指定图书添加到当前用户购物车
     * 如果当前用户购物车已存在该图书，将图书数量加1
     * 否则，在购物车中新增CartItem，数量为1
     *
     * @param bookId
     * @return
     */
    public String addCart(Integer bookId, HttpSession session) {
        User user = (User) session.getAttribute("currUser");
        CartItem cartItem = new CartItem(new Book(bookId), 1, user);
        cartItemService.addOrUpdateCartItem(cartItem, user.getCart());

        return "redirect:cart.do";
    }

    public String editCart(Integer cartItemId, Integer buyCount) {
        cartItemService.updateCartItem(new CartItem(cartItemId, buyCount));
        return "redirect:cart.do";
    }
}
