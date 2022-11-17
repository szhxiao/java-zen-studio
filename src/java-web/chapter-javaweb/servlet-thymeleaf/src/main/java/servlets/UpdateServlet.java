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

@WebServlet("/update.do")
public class UpdateServlet extends ViewBaseServlet {
    private CustomerDAO customerDAO = new CustomerDAOImpl();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 1. 设置编码
        req.setCharacterEncoding("UTF-8");
        // 2. 获取参数
        String idStr = req.getParameter("id");
        int id = Integer.parseInt(idStr);
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String birthStr = req.getParameter("birth");
        try {
            Date birth = StringUtils.stringToDate(birthStr);
            Customer customer = new Customer(id, name, email, birth);
            // 3. 执行更新
            customerDAO.update(JDBCUtils.getInstance().getConnection(), customer);

            // 4. 资源跳转
        } catch (Exception e) {
            e.printStackTrace();
        }

//        super.processTemplate("list", req, resp);
        // 进行重定向，重新给ListServlet发请求
        resp.sendRedirect("list.do");
    }
}
