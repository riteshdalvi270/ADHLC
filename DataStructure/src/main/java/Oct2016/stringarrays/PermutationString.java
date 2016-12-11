package Oct2016.stringarrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Check if one is permutation of other.
 * Created by ritesh on 10/23/16.
 */
public class PermutationString {

    public static void main(String args[]) {

        final String original = "geeksforgeeks";
        final String permuatation = "ksforgeeksgee";

        System.out.println(isStringPermutated(original,permuatation));
    }

    // nice solution (I did it).
    public static boolean isStringPermutated(final String original, final String permutation) {

        if(original.length() != permutation.length()) {
            return false;
        }

        if(original.equals(permutation)) {
            return true;
        }

        final Map<Character,Integer> countByCharacters = new HashMap<>();

        for(int i = 0; i<original.length(); i++) {

            final Character originalChar = original.charAt(i);
            final Character permutatedChar = permutation.charAt(i);

            if(countByCharacters.get(originalChar) == null) {
                int count = 1;
                countByCharacters. put(originalChar, count);
            }else {
                Integer count = countByCharacters.get(originalChar);
                count = count + 1;
                countByCharacters.put(originalChar,count);
            }

            if(countByCharacters.get(permutatedChar) == null) {
                int count = 1;
                countByCharacters. put(permutatedChar, count);
            }else {
                Integer count = countByCharacters.get(permutatedChar);
                count = count + 1;
                countByCharacters.put(permutatedChar,count);
            }
        }

        for(Integer counts: countByCharacters.values()) {

            if(counts%2!=0) {
                return false;
            }
        }

        return true;
    }
}
