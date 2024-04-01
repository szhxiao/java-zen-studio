/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Blog {
    private Integer id;
    private String title;
    private String author;
    private Date createTime;
    private Integer views;

    public Blog() {
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

    public String getCreateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(createTime);
    }

    public void setCreateTime(String createTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.createTime = dateFormat.parse(createTime);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    @Override
    public String toString() {
        return "Blog{" +id +
                ", " + title +
                ", " + author +
                ", " + createTime +
                ", " + views +
                "}";
    }
}