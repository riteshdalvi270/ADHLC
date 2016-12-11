package hackerrank;

import java.util.Scanner;

/**
 * Created by ritesh on 9/3/16.
 */
public class LexicographicalSorting {

    public static void main(String[] args) {

        final Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.nextLine();

        String arr[] = new String[n];

        for(int i=0; i<n;i++){
            arr[i] = in.nextLine();
        }

        String results[] = new String[n];

             int i = 0;
            for(String input : arr) {
                results[i] = nextPermutation(input.toCharArray());
                System.out.println(results[i]);
                i++;
            }

    }

    private static String nextPermutation(char[] array) {
        // Find longest non-increasing suffix
        int i = array.length - 1;
        while (i > 0 && array[i - 1] >= array[i])
            i--;
        // Now i is the head index of the suffix

        // Are we at the last permutation already?
        if (i <= 0)
            return "No Answer";

        // Let array[i - 1] be the pivot
        // Find rightmost element that exceeds the pivot
        int j = array.length - 1;
        while (array[j] <= array[i - 1])
            j--;
        // Now the value array[j] will become the new pivot
        // Assertion: j >= i

        // Swap the pivot with j
        char temp = array[i - 1];
        array[i - 1] = array[j];
        array[j] = temp;

        // Reverse the suffix
        j = array.length - 1;
        while (i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }

        // Successfully computed the next permutation
        return String.copyValueOf(array);
    }
}
