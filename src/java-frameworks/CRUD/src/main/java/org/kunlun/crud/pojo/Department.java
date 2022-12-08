/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.kunlun.crud.pojo;

import java.io.Serializable;
import java.util.UUID;

public class Department implements Serializable {
    private static final long serialVersionUID = UUID.randomUUID().version();

    private Integer deptId;
    private String deptName;
    // private Integer empNum;

    public Department() {
    }

    public Department(String deptName) {
        this.deptName = deptName;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    // public Integer getEmpNum() {
    //     return empNum;
    // }
    //
    // public void setEmpNum(Integer empNum) {
    //     this.empNum = empNum;
    // }


    @Override
    public String toString() {
        return "Department{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
