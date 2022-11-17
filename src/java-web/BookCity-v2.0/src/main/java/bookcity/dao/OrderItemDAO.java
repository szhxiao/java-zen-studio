/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package bookcity.dao;


import bookcity.pojo.OrderBean;
import bookcity.pojo.OrderItem;

/**
 *
 */
public interface OrderItemDAO {

    /**
     * 添加订单项
     *
     * @param orderItem 订单项
     */
    void addOrderItem(OrderItem orderItem);
}
