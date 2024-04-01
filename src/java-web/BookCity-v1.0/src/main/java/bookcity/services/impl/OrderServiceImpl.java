/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package bookcity.services.impl;

import bookcity.dao.CartItemDAO;
import bookcity.dao.OrderDAO;
import bookcity.dao.OrderItemDAO;
import bookcity.pojo.CartItem;
import bookcity.pojo.OrderBean;
import bookcity.pojo.OrderItem;
import bookcity.pojo.User;
import bookcity.services.OrderService;

import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
    private OrderDAO orderDAO;
    private OrderItemDAO orderItemDAO;
    private CartItemDAO cartItemDAO;

    @Override
    public void addOrderBean(OrderBean orderBean) {
        // 订单表添加一条记录
        orderDAO.addOrderBean(orderBean);
        // 订单详情表添加记录
        // orderBean中的orderItemList为空，应该根据用户的购物车项转换成订单项
        User currUser = orderBean.getOrderUser();
        Map<Integer, CartItem> cartItemMap = currUser.getCart().getCartItemMap();
        for (CartItem cartItem : cartItemMap.values()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setBook(cartItem.getBook());
            orderItem.setBuyCount(cartItem.getBuyCount());
            orderItem.setOrderBean(orderBean);
            System.out.println(orderItem);
            orderItemDAO.addOrderItem(orderItem);
        }

//        List<OrderItem> orderItemList = orderBean.getOrderItemList();
//        for (OrderItem orderItem : orderItemList) {
//            orderItemDAO.addOrderItem(orderItem);
//        }
        // 购物车项表中需要删除对应的记录
        for (CartItem cartItem : cartItemMap.values()) {
            cartItemDAO.deleteCartItem(cartItem);
        }

    }

    @Override
    public List<OrderBean> getOrderList(User user) {
        List<OrderBean> orderBeanList = orderDAO.getOrderList(user);
        for (OrderBean orderBean : orderBeanList) {
            Integer totalBookCount = orderDAO.getOrderTotalBookCount(orderBean);
            orderBean.setTotalBookCount(totalBookCount);
        }

        return orderBeanList;
    }
}
