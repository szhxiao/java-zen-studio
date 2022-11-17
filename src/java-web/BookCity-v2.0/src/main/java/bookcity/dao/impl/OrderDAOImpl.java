 /**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

 package bookcity.dao.impl;


 import myssm.dao.BaseDAO;
 import myssm.dao.DAOException;
 import bookcity.dao.OrderDAO;
 import bookcity.pojo.OrderBean;
 import bookcity.pojo.User;

 import java.math.BigDecimal;
 import java.sql.SQLException;
 import java.util.List;

 /**
  *
  */
 public class OrderDAOImpl extends BaseDAO implements OrderDAO {

     @Override
     public void addOrderBean(OrderBean orderBean) {
         String sql = "INSERT  INTO `t_order`(`id`,`orderNo`,`orderDate`," +
                "`orderUser`,`orderMoney`,`orderStatus`) VALUES (0,?,?,?,?,?)";
         try {
             int orderBeanId = update(sql, orderBean.getOrderNo(),
                     orderBean.getOrderDate(),
                     orderBean.getOrderUser().getId(), orderBean.getOrderMoney(),
                     orderBean.getOrderStatus());
             orderBean.setId(orderBeanId);
         } catch (SQLException e) {
             e.printStackTrace();
             throw new DAOException("Exception: OrderDAOImpl addOrderBean()");
         }
     }

     @Override
     public List<OrderBean> getOrderList(User user) {
         String sql = "SELECT * FROM `t_order` WHERE `orderUser` = ?";
         List<OrderBean> orderBeanList = null;
         try {
             orderBeanList = queryForList(OrderBean.class, sql, user.getId());
         } catch (Exception e) {
             e.printStackTrace();
             throw new DAOException("Exception: OrderDAOImpl getOrderList()");
         }
         return orderBeanList;
     }

     @Override
     public Integer getOrderTotalBookCount(OrderBean orderBean) {
         String sql = "SELECT SUM(ts.buyCount) AS totalBookCount, " +
                 "ts.orderBean FROM (SELECT tor.id, toi.buyCount, " +
                 "toi.orderBean FROM t_order tor INNER JOIN t_order_item toi " +
                 "ON tor.id = toi.orderBean WHERE tor.orderUser = ?) ts " +
                 "WHERE ts.orderBean=? GROUP BY ts.orderBean";

         try {
             return ((BigDecimal)queryComplex(sql,
                     orderBean.getOrderUser().getId(),
                     orderBean.getId())[0]).intValue();
         } catch (SQLException e) {
             e.printStackTrace();
             throw new DAOException("Exception: OrderDAOImpl " +
                     "getOrderTotalBookCount()");
         }
     }
 }
