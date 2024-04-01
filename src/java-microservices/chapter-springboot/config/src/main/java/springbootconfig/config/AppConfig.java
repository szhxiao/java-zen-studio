/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package springbootconfig.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springbootconfig.service.HelloService;

@Configuration
public class AppConfig {

    // 将方法的返回值添加到容器中，容器中组件的默认id就是方法名
    @Bean
    public HelloService helloService() {
        System.out.println("Adding component to container");
        return new HelloService();
    }
}
