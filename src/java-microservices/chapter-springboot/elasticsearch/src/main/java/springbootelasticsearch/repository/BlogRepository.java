/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package springbootelasticsearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import springbootelasticsearch.pojo.Blog;

import java.util.List;

public interface BlogRepository extends ElasticsearchRepository<Blog, Integer> {
    List<Blog> findBlogByTitle(String blogTitle);
}
