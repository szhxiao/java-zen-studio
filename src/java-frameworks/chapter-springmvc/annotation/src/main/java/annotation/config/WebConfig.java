/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package annotation.config;

import annotation.intercetpor.TestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.util.List;
import java.util.Properties;

/**
 * Web配置类，代替SpringMVC配置文件
 *
 * 1. 扫描组件， 2. 视图解析器， 3. view-controller，
 * 4. default-servlet-handler（开放静态资源访问）
 * 5. mvc注解驱动， 6. multipartResolver（文件上传解析器）
 * 7. 异常处理， 8. 拦截器
 */

// 将当前类标识为一个配置类
@Configuration
// 扫描组件
@ComponentScan("annotation/controller")
// mvc注解驱动
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    /**
     * default-servlet-handler（开放静态资源访问）
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * 拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        TestInterceptor testInterceptor = new TestInterceptor();
        registry.addInterceptor(testInterceptor).addPathPatterns("/**");
    }

    /**
     * 文件上传解析器
     * @return
     */
    /*
    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver =
                new CommonsMultipartResolver();
        return multipartResolver;
    }
    */


    /**
     * 异常处理
     * @param resolvers
     */
    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        SimpleMappingExceptionResolver exceptionResolver =
                new SimpleMappingExceptionResolver();
        Properties prop = new Properties();
        prop.setProperty("java.lang.ArithmeticException", "error");
        exceptionResolver.setExceptionMappings(prop);
        exceptionResolver.setExceptionAttribute("exception");

        resolvers.add(exceptionResolver);
    }

    /**
     * 配置生成模板解析器
     * @return
     */
    @Bean
    public ITemplateResolver templateResolver() {
        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        // ServletContextTemplateResolver需要一个ServletContext作为构造参数，可通过WebApplicationContext 的方法获得
        // ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(
        //         webApplicationContext.getServletContext());
        SpringResourceTemplateResolver templateResolver =
                new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(webApplicationContext);
        // 视图前缀
        templateResolver.setPrefix("/WEB-INF/templates/");
        // 视图后缀
        templateResolver.setSuffix(".html");
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        return templateResolver;
    }

    /**
     * 生成模板引擎并为模板引擎注入模板解析器
     *
     * @param templateResolver
     * @return
     */
    @Bean
    public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }

    /**
     * 生成视图解析器并未解析器注入模板引擎
     *
     * @param templateEngine
     * @return
     */
    @Bean
    public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setTemplateEngine(templateEngine);
        return viewResolver;
    }
}
