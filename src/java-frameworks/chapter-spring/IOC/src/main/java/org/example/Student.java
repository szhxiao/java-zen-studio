package org.example; /**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Student {
    private String[] courses;
    private List<String> books;
    private Map<String, Integer> scores;
    private List<Course> courseList;

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }

    public void setScores(Map<String, Integer> scores) {
        this.scores = scores;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "org.example.Student{" +
                "\ncourses=" + Arrays.toString(courses) +
                ", \nbooks=" + books +
                ", \nscores=" + scores +
                ", \ncourseList=" + courseList +
                '}';
    }
}
