package Oct2016.snapchat;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ritesh on 12/9/16.
 */
public class PatternMatching {

    public static void main(String args[]) {

        final String pattern = "aab";
        final String[] dictionary = new String[] {"cdf", "too", "hgfdt" ,"paa"};

        System.out.println(matchPattern(pattern,dictionary));
    }

    private static String matchPattern(final String pattern, final String[] dictionary) {

        final StringBuilder output = new StringBuilder();

        char[] patternArray = pattern.toCharArray();

        final Map<Character,Integer> counterByCharPattern = new HashMap<>();

        int[] counterPattern = new int[patternArray.length];

        for(int i = 0; i<patternArray.length; i++) {

            char patternChar = patternArray[i];

            if(counterByCharPattern.containsKey(patternChar)) {
                Integer counter = counterByCharPattern.get(patternChar);
                counter = counter + 1;

                counterByCharPattern.put(patternChar,counter);

                counterPattern[i] = counter;
            }else {
                int counter = 0;

                counterByCharPattern.put(patternChar,counter);

                counterPattern[i] = counter;
            }
        }

        for(String dictionaryValue : dictionary) {

            final Map<Character,Integer> counterByCharDic = new HashMap<>();

            boolean isPattern = false;

            char[] dictionaryArray = dictionaryValue.toCharArray();

            int[] counterDic = new int[dictionaryArray.length];

            if(patternArray.length!= dictionaryArray.length) {
                continue;
            }

            for (int i = 0; i < dictionaryArray.length; i++) {

                char dictionaryChar = dictionaryArray[i];

                if(counterByCharDic.containsKey(dictionaryChar)) {
                    Integer counter = counterByCharDic.get(dictionaryChar);
                    counter = counter + 1;

                    counterByCharDic.put(dictionaryChar,counter);

                    counterDic[i] = counter;
                }else {
                    int counter = 0;

                    counterByCharDic.put(dictionaryChar,counter);

                    counterDic[i] = counter;
                }

                if(counterPattern[i] == counterDic[i]) {
                    isPattern = true;
                }else {
                    isPattern = false;
                    break;
                }
            }

            if(isPattern) {
                output.append(dictionaryValue);
                output.append(" ");
            }
        }

        return output.toString();
    }
}
