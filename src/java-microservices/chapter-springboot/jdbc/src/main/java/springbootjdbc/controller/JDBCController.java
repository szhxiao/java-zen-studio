/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package springbootjdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class JDBCController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @ResponseBody
    @GetMapping("/query")
    public Map<String, Object> getData() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * FROM user");
        return list.get(0);
    }
}
