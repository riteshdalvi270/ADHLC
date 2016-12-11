package Oct2016.GeeksForGeeks.dynamicprogramming;

/**
 * Created by ritesh on 12/8/16.
 */
public class StringPermutation {

    public static void main(String args[]) {

        String input = "abcd";

        permute(input.toCharArray(),0,input.length()-1);
    }

    private static void permute(char[] inputArray, int start, int end) {

        if(start == end) {
            System.out.println(inputArray);
        }
        else {
            for (int i = start; i <= end; i++) {

                swap(inputArray, start, i);
                permute(inputArray, start + 1, end);
                swap(inputArray, start, i);
            }
        }
    }

    private static void swap(final char[] input, int i, int j) {

        char temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
