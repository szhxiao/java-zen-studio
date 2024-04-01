/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package bookcity.pojo;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class OrderBean {

    @NonNull
    private Integer id;
    private String orderNo;
    private LocalDateTime orderDate;
    private User orderUser;
    private Double orderMoney;
    private Integer orderStatus;

    private Integer totalBookCount;

    private List<OrderItem> orderItemList;

}
