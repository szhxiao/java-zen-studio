/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 定义类
 */
public class Person {
    // 类属性
    private String name;
    private int age;
    private String gender;

    public Person() {}

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
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
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    public void eat() {
        System.out.println(name + " is eating");
    }

    public void sleep() {
        System.out.println(name + " is sleeping");
    }

    public void talk(String language) {
        System.out.println(name + " is talking with " + language);
    }

    public static void main(String[] args) {
        // 类的实例化
        Person p1 = new Person();

        // 调用属性
        // p1.name = "Jack";
        // p1.age = 29;
        // p1.gender = "Male";
        // 应尽量使用类提供的方法操作属性
        p1.setName("Jack");
        p1.setAge(29);
        p1.setGender("Male");

        // 调用方法
        p1.eat();
        p1.sleep();
        p1.talk("Chinese");
    }    
}
