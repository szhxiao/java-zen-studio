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
public class Book {

    @NonNull
    private Integer id;
    private String bookImg;
    private String bookName;
    private Double price;
    private String author;
    private Integer saleCount;
    private Integer bookCount;
    private Integer bookStatus = 0;

}
