/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package servlets;

import dao.CustomerDAO;
import dao.impl.CustomerDAOImpl;
import entry.Customer;
import util.JDBCUtils;
import util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit.do")
public class EditServlet extends ViewBaseServlet {
    private CustomerDAO customerDAO = new CustomerDAOImpl();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String idStr = req.getParameter("id");
//        System.out.println("Got cidStr: " + idStr);
        if (StringUtils.isNotEmpty(idStr)) {
            int id = Integer.parseInt(idStr);
            try {
                Customer customer = customerDAO.getCustomerByID(
                        JDBCUtils.getInstance().getConnection(), id);
//                System.out.println(customer);
                req.setAttribute("customer", customer);
                super.processTemplate("edit", req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
