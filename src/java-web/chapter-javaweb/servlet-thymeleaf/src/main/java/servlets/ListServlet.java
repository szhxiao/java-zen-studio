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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/list.do")
public class ListServlet extends ViewBaseServlet {
    private CustomerDAO customerDAO = new CustomerDAOImpl();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();

        Integer pageNo = 1;

        String operator = req.getParameter("operator");
        String keyword = null;

        if (StringUtils.isNotEmpty(operator) && "search".equals(operator)) {
            //点击表单查询发送的请求
            // pageNo还原为1，keyword从请求参数中获取
            pageNo = 1;
            keyword = req.getParameter("keyword");
            if (StringUtils.isEmpty(keyword)) {
                keyword = "";
            }
            session.setAttribute("keyword", keyword);
        } else {
            // 不是点击查询表单发送的请求（如上一页、下一页、首页、尾页）
            // keyword应从session作用域获取
            // 实现分页查询
            String pageNoStr = req.getParameter("pageNo");
            if (StringUtils.isNotEmpty(pageNoStr)) {
                pageNo = Integer.parseInt(pageNoStr);
            }
            Object keywordObj = session.getAttribute("keyword");
            if (keywordObj != null) {
                keyword = (String) keywordObj;
            } else {
                keyword = "";
            }
        }

        session.setAttribute("pageNo", pageNo);

//        List<Customer> customerList = null;
        try {
            List<Customer> customerList = customerDAO.getAll(
                    JDBCUtils.getInstance().getConnection(), keyword, pageNo);
            session.setAttribute("customerList", customerList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // 记录总条数
            int customerCount = customerDAO.getCustomerCount(
                    JDBCUtils.getInstance().getConnection(), keyword);
            // 页数
            int pageCount = (customerCount + 5 - 1) / 5;
            session.setAttribute("pageCount", pageCount);
        } catch (Exception e) {
            e.printStackTrace();
        }

        super.processTemplate("list", req, resp);

    }
}
