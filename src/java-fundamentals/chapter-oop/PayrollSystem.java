/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.util.Scanner;

/**
 * 
 */
public class PayrollSystem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please input the month: ");
        int month = in.nextInt();
        
        Employee[] employees = new Employee[2];
        
        employees[0] = new SalariedEmployee("Tom", 1001, new MyDate(1998, 12, 30), 10000.0);
        employees[1] = new HourlyEmployee("Jack", 1002, new MyDate(1987, 11, 15), 60, 340);

        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
            
            double salary = employees[i].earnings();
            if (month == employees[i].getBirthday().getMonth()) {
                System.out.println("Happy Birthday!");
                salary += 100.0;
            }
            System.out.println(salary);
        }
    }
}