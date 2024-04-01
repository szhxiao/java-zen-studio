/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package filters;


import trans.TransactionManager;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 */

@WebFilter("*.do")
public class OpenSessionInViewFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            TransactionManager.beginTransaction();
            System.out.println("begin transaction...");
            chain.doFilter(request, response);
            TransactionManager.commit();
            System.out.println("commit transaction...");
        } catch (SQLException e) {
            e.printStackTrace();

            try {
                TransactionManager.rollback();
                System.out.println("roll back transaction...");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
