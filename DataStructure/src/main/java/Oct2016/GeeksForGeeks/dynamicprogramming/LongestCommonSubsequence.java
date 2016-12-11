package Oct2016.GeeksForGeeks.dynamicprogramming;

/**
 * Find longest common subsequence.
 * Created by ritesh on 12/3/16.
 */
public class LongestCommonSubsequence {

    public static void main(String args[]) {

        int input[] = new int[] {10,22,9,33,21,50,41,60,80};

        int max = 0;

        System.out.println(LCS(input, 0, max));
    }

    public static int LCS(int[] input, int m, int max) {

        if(m == input.length) {
            return max;
        }

        for(int i=m; i>0; i--) {

            if(input[m] < input[i]) {
                return LCS(input, m+1, max);
            }
        }

       max =  LCS(input,m+1,max + 1);

        return max;
    }
}
