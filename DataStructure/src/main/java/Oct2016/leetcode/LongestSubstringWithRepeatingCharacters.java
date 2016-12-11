package Oct2016.leetcode;

/**
 * Find length of longest substring.
 * Created by ritesh on 10/14/16.
 */
public class LongestSubstringWithRepeatingCharacters {

    public static void main(String args[]) {

        final String input = "abcabcbb"; //output: abc

        System.out.print(longestSubstring(input));
    }

    public static int longestSubstring(final String input) {

        boolean ascii[] = new boolean[256];

        int count = 0;
        int max = 0;

        for(int i = 0; i<input.length(); i++) {

            if(count >  max) {
                max = count;
            }

            count = 0;

            ascii[input.charAt(i)] =  true;
            count++;

            for(int j=i+1; j<input.length(); j++) {

                if(ascii[input.charAt(j)]) {
                   ascii = new boolean[256];
                    break;
                }else {
                    ascii[input.charAt(j)] = true;
                    count++;
                }
            }
        }

        return count>max ? count : max;
    }
}

