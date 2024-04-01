/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package springbootelasticsearch;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springbootelasticsearch.pojo.Blog;
import springbootelasticsearch.repository.BlogRepository;

@SpringBootTest
public class SpringBootElasticSearchApplicationTest {

    @Autowired
    BlogRepository blogRepository;

    @Test
    public void testIndex() {
        Blog blog = new Blog();
        blog.setId(2);
        blog.setTitle("Springboot Elasticsearch");
        blog.setAuthor("szhxiao");
        blog.setContent("Adding elasticsearch blog");
        blogRepository.save(blog);
    }

    @Test
    public void testSearch() {
        for (Blog blog: blogRepository.findBlogByTitle("springboot")) {
            System.out.println(blog);
        }
    }
}
