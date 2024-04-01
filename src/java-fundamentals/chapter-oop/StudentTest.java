/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 定义学生类
 */

public class StudentTest {
    public static void main(String[] args) {
        Student[] students = new Student[5];
        students[0] = new Student("Tom", 6, 98.0);
        students[1] = new Student("Jack", 9, 85.5);
        students[2] = new Student("Tony", 6, 88.3);
        students[3] = new Student("Kay", 8, 95.5);
        students[4] = new Student("Denny", 7, 63);

        // 遍历输出
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
        System.out.println("---------------------");
        // 使用冒泡排序算法按成绩排序
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = 0; j < students.length -1 - i; j++) {
                if (students[j].getScore() < students[j+1].getScore()) {
                    Student temp = students[j];
                    students[j] = students[j+1];
                    students[j+1] = temp;
                }
            }
        }
        for (Student student : students) {
            System.out.println(student);
        }
    }    
}
class Student {
    // 类属性
    private String name;
    private int grade;
    private double score;

    /**
     * 
     */
    public Student() {
    }

    /**
     * @param name 姓名
     * @param grade 年级
     * @param score 分数
     */
    public Student(String name, int grade, double score) {
        this.name = name;
        this.grade = grade;
        this.score = score;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the grade
     */
    public int getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(int grade) {
        this.grade = grade;
    }

    /**
     * @return the score
     */
    public double getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", grade=" + grade + ", score=" + score + "]";
    }
}


