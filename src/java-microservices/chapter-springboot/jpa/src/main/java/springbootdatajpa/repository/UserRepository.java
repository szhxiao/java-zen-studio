/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package springbootdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springbootdatajpa.pojo.User;

/**
 * 继承JpaRepository完成对数据库的操作
 */
public interface UserRepository extends JpaRepository<User, Integer> {

}
