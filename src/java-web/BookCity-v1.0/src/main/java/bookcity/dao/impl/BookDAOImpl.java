 /**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

 package bookcity.dao.impl;


 import bookcity.dao.BaseDAO;
 import bookcity.dao.BookDAO;
 import bookcity.dao.DAOException;
 import bookcity.pojo.Book;

 import java.util.List;

 /**
  *
  */
 public class BookDAOImpl extends BaseDAO implements BookDAO {


     @Override
     public List<Book> getBookList() {
         String sql = "SELECT * FROM t_book tb WHERE bookStatus = 0";
         List<Book> bookList = null;
         try {
             bookList = queryForList(Book.class, sql);
         } catch (Exception e) {
             e.printStackTrace();
             throw new DAOException("Exception: BookDAOImpl getBookList()");
         }
         return bookList;
     }

     @Override
     public Book getBook(Integer id) {
         String sql = "SELECT * FROM `t_book` tb WHERE `id` = ?";
         Book book = null;
         try {
             book = query(Book.class, sql, id);
         } catch (Exception e) {
             e.printStackTrace();
             throw new DAOException("Exception: BookDAOImpl getBook()");
         }
         return book;
     }
 }
