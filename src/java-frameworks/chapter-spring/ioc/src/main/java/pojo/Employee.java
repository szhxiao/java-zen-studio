/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package pojo;

public class Employee {
    private String name;
    private String address;

    public Employee() {
        System.out.println("Employee constructor...");
    }

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
