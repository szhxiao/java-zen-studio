/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

package listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 */
public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Servlet上下文对象初始化动作被监听到了...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Servlet上下文对象销毁动作被监听到了...");
    }
}
