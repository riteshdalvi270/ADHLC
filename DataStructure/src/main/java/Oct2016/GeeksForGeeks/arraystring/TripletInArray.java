package Oct2016.GeeksForGeeks.arraystring;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ritesh on 12/10/16.
 */
public class TripletInArray {

    public static void main(String args[]) {

        int[] input = new int[]{12,3,4,1,6,9};

        int sum = 24;

        System.out.println(naiveFindTriplet(input,sum));
    }

    private static boolean naiveFindTriplet(int[] input, int sum) {

        for(int i = 0; i<input.length; i++) {

            for(int j = i+1; j<input.length; j++) {

                for(int k=j+1; k<input.length; k++) {

                    if(input[i] + input[j] + input[k] ==  sum)  {
                        System.out.println(input[i] + " " + input[j] + " "+ input[k]);
                       return true;
                    }
                }
            }
        }

        return false;
    }
}
