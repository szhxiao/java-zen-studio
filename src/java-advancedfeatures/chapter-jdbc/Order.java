/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.sql.Date;
import java.time.LocalDate;

/**
 * 
 */
public class Order {
    private int id;
    private String name;
//    private LocalDate date;
    private Date date;
    public Order() {
    }

//    public Order(int id, String name, LocalDate date) {
//        this.id = id;
//        this.name = name;
//        this.date = date;
//    }


    public Order(int id, String name, Date date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public LocalDate getDate() {
//        return date;
//    }
//
//    public void setDate(LocalDate date) {
//        this.date = date;
//    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }

    public static void main(String[] args) {
        
    }    
}
