/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 多态
 */
public class PolymorphicTest {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.eat();

        Student student = new Student("Jenny", 26, "Female", 9, "Chinese", 55.0);
        student.eat();
        student.talk("English");

        // 多态
        Person p2 = new Teacher("LingMing", 32, "Male", "Professor", "Chinese", 55000);
        p2.eat();
        p2.talk("Chinese");

        // 向下转型
        Teacher teacher = (Teacher) p2;
        teacher.teach();
    }    
}
