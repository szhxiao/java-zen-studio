/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package transaction.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void increaseBalance(int id) {
        String sql = "UPDATE test.t_account SET account=account+? WHERE id=?";
        jdbcTemplate.update(sql, 10000, id);
        System.out.println("update done.");
    }

    @Override
    public void decreaseBalance(int id) {
        String sql = "UPDATE test.t_account SET account=account-? WHERE id=?";
        jdbcTemplate.update(sql, 10000, id);
        System.out.println("update done.");
    }
}
