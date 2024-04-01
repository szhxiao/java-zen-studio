 /**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

 package bookcity.services;


 import bookcity.pojo.Book;
 import bookcity.pojo.User;

 import java.util.List;

 /**
  *
  */
 public interface BookService {

     /**
      * 获取图书列表
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
