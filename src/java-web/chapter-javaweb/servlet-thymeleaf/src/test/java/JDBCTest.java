import dao.CustomerDAO;
import dao.impl.CustomerDAOImpl;
import org.junit.Test;
import util.JDBCUtils;

public class JDBCTest {
    @Test
    public void testJDBC() {
        try {
            System.out.println(JDBCUtils.getInstance().getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetCustomerCount() {
//        CustomerDAO customerDAO = new CustomerDAOImpl();
//        try {
//            System.out.println(customerDAO.getCustomerCount(JDBCUtils.getInstance().getConnection()));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
