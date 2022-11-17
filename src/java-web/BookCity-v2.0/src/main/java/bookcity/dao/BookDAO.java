 /**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

 package bookcity.dao;


 import bookcity.pojo.Book;

 import java.util.List;

 /**
  *
  */
 public interface BookDAO {

     /**
      * 获取所有图书列表
      *
      * @return
      */
     List<Book> getBookList();

     /**
      * 通过id获取书籍信息
      *
      * @param id
      * @return
      */
     Book getBook(Integer id);
 }
