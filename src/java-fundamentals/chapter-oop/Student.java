/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 定义类
 */
public class Student extends Person {
    private int grade;
    private String major;
    private double score;

    public Student() {}

    public Student(String name, int age, 
        String gender, int grade, String major, double score) {
        super(name, age, gender);
        this.grade = grade;
        this.major = major;
        this.score = score;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    // 重写父类方法
    public void eat() {
        super.eat();
        // eat();
        System.out.println(this.getName() + " should be nutritious and balanced");
    }

    public static void main(String[] args) {
        
    }    
}
