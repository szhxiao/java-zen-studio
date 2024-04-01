/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package bookcity.pojo;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class CartItem {

    @NonNull
    private Integer id;
    private Book book;
    private Integer buyCount;
    private User userBean;
    private Double subtotal;

    public CartItem(@NonNull Integer id, Integer buyCount) {
        this.id = id;
        this.buyCount = buyCount;
    }

    public CartItem(Book book, Integer buyCount, User userBean) {
        this.book = book;
        this.buyCount = buyCount;
        this.userBean = userBean;
    }

    public Double getSubtotal() {
        BigDecimal price = new BigDecimal("" + getBook().getPrice());
        BigDecimal count = new BigDecimal("" + buyCount);
        subtotal = price.multiply(count).doubleValue();
        return subtotal;
    }
}
