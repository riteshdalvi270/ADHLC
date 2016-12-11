package Oct2016.GeeksForGeeks.arraystring;

import java.util.Set;

/**
 * Created by ritesh on 12/10/16.
 */
public class TripletInArray {

    public static void main(String args[]) {

        int[] input = new int[]{12,3,4,1,6,9};

        int sum = 24;

        Set<Integer> triplet = naiveFindTriplet(input,sum);


    }

    private static Set<Integer> naiveFindTriplet(int[] input, int sum) {

        for(int i = 0; i<input.length; i++) {

            for(int j = 0; j<input.length; j++) {

                for(int k=0; k<input.length; k++) {

                }
            }
        }
    }
}
