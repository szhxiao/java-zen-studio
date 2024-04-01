/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package bookcity.pojo;

import lombok.*;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

@NoArgsConstructor
public class Cart {

    @Getter
    @Setter
    private Map<Integer, CartItem> cartItemMap;     // 购物车项集合，key为Book的id

    private Double totalMoney;                      // 购物车总金额
    private Integer totalCount;                     // 购物项的数量
    private Integer totalBookCount;                 // 购物车中书本总数量

    public Double getTotalMoney() {
        totalMoney = 0.0;

        System.out.println(cartItemMap);

        if (cartItemMap != null && cartItemMap.size() > 0) {
            Set<Map.Entry<Integer, CartItem>> entries = cartItemMap.entrySet();
            // 解决Double类型的精度问题
            BigDecimal total = new BigDecimal("" + 0);

            for (Map.Entry<Integer, CartItem> entry : entries) {
                CartItem item = entry.getValue();
//                totalMoney =
//                        totalMoney + item.getBook().getPrice() * item.getBuyCount();
                // 解决Double类型的精度问题
                BigDecimal price =
                        new BigDecimal("" + item.getBook().getPrice());
                BigDecimal count = new BigDecimal("" + item.getBuyCount());
                total = total.add(price.multiply(count));
            }
            totalMoney = total.doubleValue();
        }
        return totalMoney;
    }

    public Integer getTotalCount() {
        totalCount = 0;
        if (cartItemMap != null && cartItemMap.size() > 0) {
            totalCount = cartItemMap.size();
        }
        return totalCount;
    }

    public Integer getTotalBookCount() {
        totalBookCount = 0;
        if (cartItemMap != null && cartItemMap.size() > 0) {
            for (CartItem item : cartItemMap.values()) {
                totalBookCount += item.getBuyCount();
            }
        }
        return totalBookCount;
    }
}
