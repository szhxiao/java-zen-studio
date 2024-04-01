/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package springbootamqp.pojo;

/**
 * 应符合JavaBean规范
 * 特别是无参构造器必须有
 */
public class Book {
    private String bookName;
    private String author;

    public Book() {
    }

    public Book(String bookName, String author) {
        this.bookName = bookName;
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" + bookName +
                ", " + author +
                "}";
    }
}
