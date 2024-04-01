/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package bookcity.services.impl;

import bookcity.dao.BookDAO;
import bookcity.dao.UserDAO;
import bookcity.pojo.Book;
import bookcity.pojo.User;
import bookcity.services.BookService;
import bookcity.services.UserService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDAO bookDAO;

    @Override
    public List<Book> getBookList() {
        return bookDAO.getBookList();
    }

    @Override
    public Book getBook(Integer id) {
        return bookDAO.getBook(id);
    }
}
