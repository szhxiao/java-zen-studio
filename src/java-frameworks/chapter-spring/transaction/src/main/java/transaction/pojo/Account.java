/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package transaction.pojo;

public class Account {
    private Integer id;
    private String name;
    private Double account;

    public Account() {
    }

    public Account(Integer id, String name, Double account) {
        this.id = id;
        this.name = name;
        this.account = account;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAccount() {
        return account;
    }

    public void setAccount(Double account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Account{" +id +
                ", " + name +
                ", " + account +
                "}";
    }
}
