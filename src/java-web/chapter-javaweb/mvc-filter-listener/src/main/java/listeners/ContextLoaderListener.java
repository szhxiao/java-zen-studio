/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

package listeners;

import ioc.BeanFactory;
import ioc.ClassPathXMLApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 */
@WebListener
public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 1. 获取Servlet上下文
        ServletContext application = sce.getServletContext();
        // 2. 获取上下文初始化参数
        String path = application.getInitParameter("contextConfigLocation");
        // 3. 创建IOC容器
        BeanFactory beanFactory = new ClassPathXMLApplicationContext(path);
        // 4. 将IOC容器保存到application作用域
        application.setAttribute("beanFactory", beanFactory);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
//        System.out.println("Servlet上下文对象销毁动作被监听到了...");
    }
}
