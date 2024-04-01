/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package springbootelasticsearch.pojo;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "website")
public class Blog {
    private Integer id;
    private String title;
    private String author;
    private String content;

    public Blog() {
    }

    public Blog(Integer id, String title, String author, String content) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Blog{" + id +
                ", " + title +
                ", " + author +
                ", " + content +
                "}";
    }
}
