/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * ArrayUtil
 */

public class ArrayUtil {
    
    /**
     * Return the maximum number in array.
     * 
     * @param arr the array
     * @return the maximum number in array
     */
    public int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * Return the minimum number in array.
     * 
     * @param arr the array
     * @return the minimum number in array
     */
    public int getMin(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    /**
     * Return the sum of elements in array.
     * 
     * @param arr the array
     * @return the sum of elements in array
     */
    public int getSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    /**
     * Return the average value of elements in array.
     * 
     * @param arr the array
     * @return the average value of elements in array
     */
    public int getAverage(int[] arr) {
        return getSum(arr) / arr.length;
    }

    /**
     * Reverse the elements in array.
     * 
     * @param arr the array
     */
    public void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }
    }

    /**
     * Copy a array to another array.
     * 
     * @param arr the source array
     * @param length the new array length
     * @return a new array including all elements of the source array
     */
    public int[] copy(int[] arr, int length) {
        if (length < arr.length) {
            System.out.println("Error new array length");
            return null;
        } else {
            int[] arrCopy = new int[length];
            for (int i = 0; i < arr.length; i++) {
                arrCopy[i] = arr[i];
            }
            return arrCopy;
        }
    }

    /**
     * Copy a array to another array.
     * 
     * @param arr the source array
     * @return a new array with the same elements
     */
    public int[] copy(int[] arr) {
        return copy(arr, arr.length);
    }

    /**
     * Sort the array by Bubble algorithm.
     * 
     * @param arr the array
     */
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    /**
     * Return the index value if the destination number is in the array.
     * 
     * @param arr the array
     * @param dest the number to find
     * @return the index value if the destination number is in the array;
     *         -1 otherwise
     */
    public int getIndex(int[] arr, int dest) {
        for (int i = 0; i < arr.length; i++) {
            if (dest == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Print the elements in the array.
     * 
     * @param arr the array
     */
    public void print(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length-1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[arr.length-1] + "]");
    }

    /**
     * unit test
     * 
     * @param args arguments of array
     */
    public static void main(String[] args) {
        
    }    
}
