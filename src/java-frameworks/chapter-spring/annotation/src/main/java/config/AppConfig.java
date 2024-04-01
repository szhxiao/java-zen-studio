/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pojo.User;

@Configuration
public class AppConfig {
    @Bean
    public User user() {
        return new User();
    }
}
