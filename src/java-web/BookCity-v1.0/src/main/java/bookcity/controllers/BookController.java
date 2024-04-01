/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package bookcity.controllers;


import bookcity.pojo.Book;
import bookcity.pojo.User;
import bookcity.services.BookService;
import bookcity.services.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;

public class BookController {
    private BookService bookService;

    public String index(HttpSession session) {
        List<Book> bookList = bookService.getBookList();
        session.setAttribute("bookList", bookList);
        for (Book book : bookList) {
            System.out.println(book);
        }
        return "index";
    }

}
