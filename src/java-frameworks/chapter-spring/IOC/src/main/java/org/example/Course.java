package org.example;

/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */


public class Course {
    private String cname;

    /**
     * @param cname the course name to set
     */
    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "org.example.Course{" +
                "cname='" + cname + '\'' +
                '}';
    }
}
