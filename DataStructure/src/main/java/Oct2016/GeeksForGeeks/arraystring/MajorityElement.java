package Oct2016.GeeksForGeeks.arraystring;

import java.util.HashMap;
import java.util.Map;

/**
 * Majority element.
 * Created by ritesh on 11/16/16.
 */
public class MajorityElement {

    public static void main(String args[]) {

        int input[] = new int[]{3,3,4,2,4,4,2,4,4};

        final Map<Integer,Integer> elementsByCount = majorityElement(input);

        for(final Map.Entry<Integer,Integer> entrySet : elementsByCount.entrySet()) {

            if(entrySet.getValue() > (input.length/2)) {
                System.out.println(entrySet.getKey());
                break;
            }
        }
    }

    public static Map<Integer,Integer> majorityElement(final int[] input) {

        final Map<Integer,Integer> elementsByCounts = new HashMap<>();

        for(int i = 0; i< input.length; i++) {

            if(elementsByCounts.get(input[i])==null) {
                elementsByCounts.put(input[i],1);
            }else {
                Integer count = elementsByCounts.get(input[i]);
                count = count+1;
                elementsByCounts.put(input[i],count);
            }
        }

        return elementsByCounts;
    }
}
