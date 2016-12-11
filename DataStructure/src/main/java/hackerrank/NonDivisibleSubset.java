package hackerrank;

import java.util.*;

/**
 * Created by ritesh on 9/1/16.
 */
public class NonDivisibleSubset {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int k = in.nextInt();

        long arr[] = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }


        final Set<Long> subset = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                long sum = arr[i] + arr[j];

                if (sum % k != 0) {

                    subset.add(arr[i]);
                    subset.add(arr[j]);
                }
            }
        }

        for(final Long s : subset){

            System.out.println(s);
        }

        System.out.println(subset.size());
    }
}
