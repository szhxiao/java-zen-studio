/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 
 */
public class Data {
    public static final int EMPLOYEE = 10;
    public static final int PROGRAMER = 11;
    public static final int DESIGNER = 12;
    public static final int ARCHITECT = 13;

    public static final int PC = 21;
    public static final int NOTEBOOK = 22;
    public static final int PRINTER = 23;

    // Employee: 10, id, name, age, salary
    // Programer: 11, id, name, age, salary
    // Designer: 12, id, name, age, salary, bonus
    // Architect: 13, id, name, age, salary, bonus, stock
    public static final String[][] EMPLOYEES = {
        {"10", "1", "徐直军", "22", "3000"},
        {"13", "2", "马化腾", "32", "10000", "15000", "2000"},
        {"11", "3", "李彦宏", "23", "7000"},
        {"11", "4", "刘强东", "24", "7300"},
        {"12", "5", "雷军", "28", "10000", "5000"},
        {"11", "6", "任志强", "22", "6800"},
        {"12", "7", "张一鸣", "29", "19800", "15000", "2500"},
        {"13", "8", "杨元庆", "30", "10800", "5200", "4000"},
        {"12", "9", "史主柱", "26", "9800", "5500"},
        {"11", "10", "丁磊", "21", "6600"},
        {"11", "11", "张朝阳", "25", "7100"},
        {"12", "12", "杨致远", "27", "9600", "4800"}
    };

    public static final String[][] EQUIPMENTS = {
        {},
        {"22", "Level", "6000"},
        {"21", "DELL", "NEC17"},
        {"21", "DELL", "SamSung"},
        {"23", "Canon", "SamSung"},
        {"21", "ASUS", "SamSung"},
        {"21", "ASUS", "SamSung"},
        {"23", "Huawei", "Honor"},
        {"22", "HP", "5800"},
        {"21", "DELL", "NEC"},
        {"21", "ASUS", "SamSung"},
        {"22", "HP", "5800"}
    };
    
}
