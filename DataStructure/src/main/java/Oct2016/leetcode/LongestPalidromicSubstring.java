package Oct2016.leetcode;

/**
 * find longest palidromic substring.
 * eg forgeeksskeegfor, output: geeksskeeg
 * Created by ritesh on 10/15/16.
 */
public class LongestPalidromicSubstring {

    public static void main(String args[]) {
        final String input = "forgeeksskeegfor";

        System.out.println(longestPalidromicSubstring(input));
    }

    public static String longestPalidromicSubstring(final String input) {

        StringBuilder output = new StringBuilder();

        String longestPalidrome = null;

        int length = 0;

        for(int i=0; i<input.length(); i++) {

            int count = 0;

            int k = i;

            for (int j=input.length()-1; j>0; j--) {

                if(i > j) {
                    break;
                }

                if(k!=j && input.charAt(k) == input.charAt(j)) {
                    count++;
                    output.append(input.charAt(k));
                    k++;
                }else {

                    if(k!=i && output.length() > 0) {
                        k = i;
                        output = new StringBuilder();
                    }
                }
            }

            if(count > length) {
                length = count;
                longestPalidrome = output.toString();
            }
        }

        return longestPalidrome;
    }
}
