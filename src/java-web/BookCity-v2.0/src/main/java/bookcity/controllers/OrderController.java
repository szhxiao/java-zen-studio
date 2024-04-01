/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package bookcity.controllers;

import bookcity.pojo.OrderBean;
import bookcity.pojo.User;
import bookcity.services.OrderService;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class OrderController {
    private OrderService orderService;

    public String checkout(HttpSession session) {
        OrderBean orderBean = new OrderBean();
        orderBean.setOrderNo(UUID.randomUUID().toString() + "_" + LocalDateTime.now().toString());
        orderBean.setOrderDate(LocalDateTime.now());

        User user = (User)session.getAttribute("currUser");
        orderBean.setOrderUser(user);

        orderBean.setOrderMoney(user.getCart().getTotalMoney());
        orderBean.setOrderStatus(0);

        orderService.addOrderBean(orderBean);

        return "index";
    }

    public String getOrderList(HttpSession session) {
        User currUser = (User) session.getAttribute("currUser");
        List<OrderBean> orderList = orderService.getOrderList(currUser);

        currUser.setOrderList(orderList);

        session.setAttribute("currUser", currUser);

        return "order/order";
    }
}
