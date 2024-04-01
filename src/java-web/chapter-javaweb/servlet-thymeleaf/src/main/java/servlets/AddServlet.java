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
import java.sql.Date;

@WebServlet("/add.do")
public class AddServlet extends ViewBaseServlet {
    private CustomerDAO customerDAO = new CustomerDAOImpl();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 设置编码，防止乱码
        req.setCharacterEncoding("UTF-8");

        // get id
        String idStr = req.getParameter("id");
        Integer id = Integer.parseInt(idStr);
        // get name
        String name = req.getParameter("name");
        // get email
        String email = req.getParameter("email");
        // get birth
        String birthStr = req.getParameter("birth");

        try {
            Date birth = StringUtils.stringToDate(birthStr);
            Customer customer = new Customer(id, name, email, birth);

            customerDAO.insert(JDBCUtils.getInstance().getConnection(), customer);
        } catch (Exception e) {
            e.printStackTrace();
        }

        super.processTemplate("list", req, resp);
    }
}
