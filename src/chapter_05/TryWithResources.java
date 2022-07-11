
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class TryWithResources {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(new File("test.txt"))) {
            while(scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
