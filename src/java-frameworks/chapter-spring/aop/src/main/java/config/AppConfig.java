/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package config;

import org.springframework.context.annotation.*;
import pojo.User;
import service.UserService;
import service.UserServiceImpl;

@Configuration
@ComponentScans({@ComponentScan("pojo"), @ComponentScan("service"), @ComponentScan("dao")})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {
    /*
    @Bean
    public User user() {
        return new User();
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }
    */
}
