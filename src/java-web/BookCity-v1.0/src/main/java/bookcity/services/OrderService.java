/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package bookcity.services;

import bookcity.pojo.OrderBean;
import bookcity.pojo.User;

import java.util.List;

public interface OrderService {

    /**
     * 添加订单
     *
     * @param orderBean
     */
    void addOrderBean(OrderBean orderBean);

    /**
     * 获取指定用户订单列表
     *
     * @param user 用户
     * @return
     */
    List<OrderBean> getOrderList(User user);
}
