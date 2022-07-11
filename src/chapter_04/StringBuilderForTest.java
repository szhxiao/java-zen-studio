            
public class StringBuilderForTest {
    public static void main(String[] args) {
        String[] arr = {"he", "llo", "wo", "rld"};
        String str = "";
        for(int i = 0; i < arr.length; i++) {
            str += arr[i];
        }
        System.out.println(str);
    }
}