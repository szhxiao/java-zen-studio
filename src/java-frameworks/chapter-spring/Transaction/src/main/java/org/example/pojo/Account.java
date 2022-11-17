/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.example.pojo;

import lombok.*;

@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Account {
    @NonNull
    private Integer id;
    private String name;
    private Double account;

}
