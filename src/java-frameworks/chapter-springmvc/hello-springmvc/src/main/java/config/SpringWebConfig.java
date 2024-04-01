/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "controller")
public class SpringWebConfig {
}
