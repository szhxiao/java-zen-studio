/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package bookcity.pojo;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class OrderItem {

    @NonNull
    private Integer id;
    private Book book;
    private Integer buyCount;
    private OrderBean orderBean;

}
