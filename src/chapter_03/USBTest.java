/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 接口
 */

interface USB {
    // 
    double TRANSFER_SPEED = 3.0;

    void start();
    void stop();
}

class Flash implements USB {

    @Override
    public void start() {
        System.out.println("flash is starting");
    }

    @Override
    public void stop() {
        System.out.println("flash is stopping");
    }
}

class Printer implements USB {

    @Override
    public void start() {
        System.out.println("printer is starting");        
    }

    @Override
    public void stop() {
        System.out.println("printer is stopping");        
    }
}

class Computer {
    public void transferDate(USB usb) {
        usb.start();
        System.out.println(usb + " is transferring data");
        usb.stop();
    }
}

public class USBTest {
    public static void main(String[] args) {
        Computer computer = new Computer();
        Flash flash = new Flash();
        computer.transferDate(flash);
        System.out.println("------------");
        
        Printer printer = new Printer();
        computer.transferDate(printer);
        System.out.println("------------");

        USB disk = new USB() {
            @Override
            public void start() {
                System.out.println("hard disk is starting");
            }

            @Override
            public void stop() {
                System.out.println("hard disk is stopping");
            }
        };
        disk.start();
        disk.stop();
    }
}