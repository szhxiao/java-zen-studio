/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

public class InternalForward extends HttpServlet {


    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("hello").forward(req, res);
    }

}
