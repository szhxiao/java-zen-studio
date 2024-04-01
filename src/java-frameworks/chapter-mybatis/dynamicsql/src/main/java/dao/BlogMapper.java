/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package dao;

import org.apache.ibatis.annotations.Delete;
import pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    void saveBlog(Blog blog);

    void updateBlog(Map<String, Object> blogMap);

    void deleteBlog(Integer id);

    Blog getBlogById(Integer id);

    List<Blog> getAllBlogs();

    List<Blog> getBlogByConditions(Map<String, Object> conditions);
}
