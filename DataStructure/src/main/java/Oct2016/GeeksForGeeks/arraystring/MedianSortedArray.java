package Oct2016.GeeksForGeeks.arraystring;

import java.util.Arrays;

/**
 * find the median of two sorted array.
 * Created by ritesh on 10/17/16.
 */
public class MedianSortedArray {

    public static void main(String args[]) {

        int ar1[] = {1, 12, 15, 26, 38, 40};
        int ar2[] = {2, 13, 17, 30, 45, 49};

        System.out.println(findMedian(ar1, ar2, ar1.length));

        System.out.println(getMedian(ar1,ar2,ar1.length));
    }


    //Correct
    public static int findMedian(int input1[], int input2[], int n) {

        int i = 0;
        int j = 0;

        int m1 = -1, m2 =-1;

        for(int count = 0; count<=n; count++) {

            if(i == n) {
                m1 = m2;
                m2 = input2[0];
                break;
            }

            if(j == n) {
                m1 = m2;
                m2 = input1[0];
                break;
            }

            if(input1[i] < input2[j]) {
                m1 = m2;
                m2 = input1[i];
                i++;
            }else {

                m1 = m2;
                m2 = input2[j];
                j++;
            }
        }

        return (m1+m2)/2;
    }

    public static int getMedian(int ar1[], int ar2[], int n) {
         /* return -1  for invalid input */
        if (n <= 0)
            return -1;
        if (n == 1)
            return (ar1[0] + ar2[0])/2;
        if (n == 2)
            return (Math.max(ar1[0], ar2[0]) + Math.min(ar1[1], ar2[1])) / 2;

        int m1 = median(ar1, n); /* get the median of the first array */
        int m2 = median(ar2, n); /* get the median of the second array */

    /* If medians are equal then return either m1 or m2 */
        if (m1 == m2)
            return m1;

    /* if m1 < m2 then median must exist in ar1[m1....] and
        ar2[....m2] */
        if (m1 < m2)
        {
            if (n % 2 == 0)
                return getMedian(Arrays.copyOfRange(ar1, n/2 - 1, n), ar2, n - n/2 +1);
            return getMedian(Arrays.copyOfRange(ar1 , n/2, n), ar2, n - n/2);
        }

    /* if m1 > m2 then median must exist in ar1[....m1] and
        ar2[m2...] */
        if (n % 2 == 0)
            return getMedian(Arrays.copyOfRange(ar2 , n/2 - 1,n), ar1, n - n/2 + 1);
        return getMedian(Arrays.copyOfRange(ar2 , n/2,n), ar1, n - n/2);
    }

    public static int median(int arr[], int n)
    {
        if (n%2 == 0)
            return (arr[n/2] + arr[n/2-1])/2;
        else
            return arr[n/2];
    }
}
