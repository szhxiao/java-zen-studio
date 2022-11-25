/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package pojo;

import java.util.List;

public class Department {
    private Integer id;
    private String departmentName;

    public Department() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }


    @Override
    public String toString() {
        return "Department{" + id +
                ", " + departmentName +
                "}";
    }
}
