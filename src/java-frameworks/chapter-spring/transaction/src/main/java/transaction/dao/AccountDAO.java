/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package transaction.dao;


public interface AccountDAO {
    void increaseBalance(int id);
    void decreaseBalance(int id);
}
