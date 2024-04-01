/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 
 */
public class StringComparison {
    public static void main(String[] args) {
        long startTime = 0L;
        long endTime = 0L;

        String text = "";
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");

        // StringBuffer
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer执行时间：" + (endTime - startTime));

        // StringBuilder
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder执行时间：" + (endTime - startTime));

        // String
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            text = text + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String执行时间：" + (endTime - startTime));
    }    
}

/**
 * output:
 * StringBuffer执行时间：17
 * StringBuilder执行时间：8
 * String执行时间：3988
 */