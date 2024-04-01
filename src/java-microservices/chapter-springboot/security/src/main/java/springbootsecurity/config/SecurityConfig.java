/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package springbootsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        /*
        http.authorizeHttpRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");
        http.formLogin();
        */

        http
                .authorizeRequests((authorize) -> authorize
                        .antMatchers("/").permitAll()
                        .antMatchers("/level1/**").hasRole("VIP1")
                        .antMatchers("/level2/**").hasRole("VIP2")
                        .antMatchers("/level3/**").hasRole("VIP3")
                )
                // .formLogin()
                // 定制登录页，默认post形式的/login代表处理登录
                .formLogin().usernameParameter("user").passwordParameter("pwd")
                .loginPage("/userlogin")
                // 默认自动开启，可配置注销后的页面
                .and()
                .logout().logoutSuccessUrl("/")
                .and()
                .rememberMe();

        // http.logout();

        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        /*
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("123456")
                .roles("VIP1", "VIP2", "VIP3")
                .build();
        return new InMemoryUserDetailsManager(user);
         */

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("123456")
                .roles("VIP1", "VIP2", "VIP3")
                .build();

        UserDetails zhangsan = User.withDefaultPasswordEncoder()
                .username("zhangsan")
                .password("123456")
                .roles("VIP1")
                .build();

        return new InMemoryUserDetailsManager(admin, zhangsan);
    }
}
