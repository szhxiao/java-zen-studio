/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * Lock
 */

class Clerk {
    private int productCount = 0;

    public synchronized void produce() {
        if (productCount < 20) {
            productCount++;
            System.out.println(Thread.currentThread().getName() 
                + ": 开始生产第" + productCount + "个产品");

            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consume() {
        if (productCount > 0) {
            System.out.println(Thread.currentThread().getName() 
                + ": 开始消费第" + productCount + "个产品");
            productCount--;

            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class Producer extends Thread {
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": 开始生产产品...");

        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.produce();
        }
    }

    
}

class Consumer extends Thread {
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": 开始消费产品...");

        while (true) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            clerk.consume();
        }
    }

    
}


public class ProductTest {
    
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer p1 = new Producer(clerk);

        Consumer c1 = new Consumer(clerk);
        Consumer c2 = new Consumer(clerk);

        p1.start();
        c1.start();
        c2.start();
    }
}
