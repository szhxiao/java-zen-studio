/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 接口
 */

interface Flyable {
    // 全局常量
    public static final int MAX_SPEED = 7900;
    int MIN_SPEED = 1;

    // 抽象方法
    public abstract void fly();
    void stop();

    // 静态方法
    static void destination() {
        System.out.println("destination: Beijing" );
    }

    // 默认方法
    default void distance() {
        System.out.println("get distance");
    }
}

interface Attackable {
    void attack();
}

class Plane implements Flyable {

    @Override
    public void fly() {
        System.out.println("the plane is flying in the sky");
    }

    @Override
    public void stop() {
        System.out.println("the plane stopped on the ground");
    }
}

class Bullet implements Flyable, Attackable {

    @Override
    public void attack() {
        System.out.println("the bullet is attackable");
    }

    @Override
    public void fly() {
        System.out.println("the bullet is flying");
    }

    @Override
    public void stop() {
        System.out.println("the bullet stopped");
    }

}

public class InterfaceTest {
    public static void main(String[] args) {
        System.out.println(Flyable.MAX_SPEED);
        System.out.println(Flyable.MIN_SPEED);

        Plane p = new Plane();
        p.fly();
        p.stop();
        p.distance();
        Flyable.destination();
    }
}