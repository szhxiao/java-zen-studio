
/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package utils;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

public class MyBatisUtilsTest {
    @Test
    public void testMyBatisUtils() {
        SqlSession sqlSession = utils.MyBatisUtils.getSqlSession();
        System.out.println(sqlSession);
    }
}
