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

public class ServletLifeCycle extends HttpServlet {

    public ServletLifeCycle() {
        System.out.println("instancing...");
    }


    @Override
    public void init() throws ServletException {
        System.out.println("initializing...");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("servicing...");
    }

//    @Override
//    public void destory() {
//        System.out.println("desotry...");
//    }

}
