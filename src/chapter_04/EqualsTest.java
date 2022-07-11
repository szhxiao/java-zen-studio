
public class EqualsTest {
    public static void main(String[] args) {
        
        String str1 = new String("ab");
        String str2 = new String("ab");

        
        String a = "ab";
        String b = "ab";

        System.out.println("a == b: " + (a == b));
        System.out.println("str1 == str2: " + (str1 == str2));
        System.out.println("str1.equals(str2): " + str1.equals(str2));
    }
}