/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 */

class Account {
    private double balance;

    public Account() {
        this.balance = 0;
    }

    public Account(double balance) {
        this.balance = balance;
    }

    // public synchronized void deposit(double amount) {
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("提示：" + Thread.currentThread().getName() 
                + "存入成功，余额为" + balance);
        }
    }
}

class Customer extends Thread {
    private Account account;

    public Customer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account.deposit(1000);
        }
    }
}

public class AccountTest {
    
    public static void main(String[] args) {
        Account account = new Account();
        Customer c1 = new Customer(account);
        Customer c2 = new Customer(account);

        c1.start();
        c2.start();
    }
}
