/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package service;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void add();
    void update();
    void query();
    void remove();
}
