/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package bookcity.dao.impl;

import bookcity.dao.BaseDAO;
import bookcity.dao.DAOException;
import bookcity.dao.OrderItemDAO;
import bookcity.pojo.OrderItem;

import java.sql.SQLException;

public class OrderItemDAOImpl extends BaseDAO implements OrderItemDAO {
    @Override
    public void addOrderItem(OrderItem orderItem) {
        String sql = "INSERT INTO `t_order_item`(`id`,`book`,`buyCount`," +
                "`orderBean`) VALUES (0,?,?,?)";
        try {
            update(sql, orderItem.getBook().getId(), orderItem.getBuyCount(),
                    orderItem.getOrderBean().getId());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException(
                    "Exception: OrderItemDAOImpl addOrderItem()");
        }
    }
}
