/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 成员内部类
 */

class Computer {
    private String brand;
    private int price;

    public void readData() {
        System.out.println("Computer is reading data to cache");
    }

    // 静态成员内部类
    static class CPU {
        int frequency;
        String instruction;

        public void compute() {
            System.out.println("CPU can do " + frequency + " instructions in a second");
        }
    }
    // 非静态成员内部类
    class Cache {
        int capacity;

        Cache() {}

        Cache(int capacity) {
            this.capacity = capacity;
        }

        public void cache() {
            // Computer.this.readData();
            readData();
            System.out.println("Cache could storage " + capacity + " GB data");
        }
    }
}

public class InnerClassTest {
    public static void main(String[] args) {
        // 创建CPU实例（静态成员内部类）
        Computer.CPU cpu = new Computer.CPU();
        cpu.compute();

        // 创建Cache实例（非静态成员内部类）
        Computer computer = new Computer();
        Computer.Cache cache = computer.new Cache(500);
        cache.cache();
    }
}