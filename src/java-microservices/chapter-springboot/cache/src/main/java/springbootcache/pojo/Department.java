/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package springbootcache.pojo;

import org.springframework.stereotype.Component;

@Component
public class Department {
    private Integer id;
    private String deptName;

    public Department() {
    }

    public Department(Integer id, String deptName) {
        this.id = id;
        this.deptName = deptName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Department{" + id +
                ", " + deptName +
                "}";
    }
}
