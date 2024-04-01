/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package servlets;

import dao.CustomerDAO;
import dao.impl.CustomerDAOImpl;
import util.JDBCUtils;
import util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete.do")
public class DeleteServlet extends ViewBaseServlet {
    private CustomerDAO customerDAO = new CustomerDAOImpl();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String idStr = req.getParameter("id");
        if (StringUtils.isNotEmpty(idStr)) {
            int id = Integer.parseInt(idStr);

            try {
                customerDAO.deleteById(JDBCUtils.getInstance().getConnection(), id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        resp.sendRedirect("list.do");
    }
}
