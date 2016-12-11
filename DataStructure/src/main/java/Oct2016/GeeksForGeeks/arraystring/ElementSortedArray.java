package Oct2016.GeeksForGeeks.arraystring;

/**
 * Search an element in a sorted array.
 * Created by ritesh on 11/20/16.
 */
public class ElementSortedArray {

    public static void main(String args[]) {

        int input[] = new int[]{3,4,5,1,2};

        System.out.println(findElementInSortedArray(input,0,input.length-1,2));
    }

    public static int findElementInSortedArray(final int[] input, int start, int end, int element) {

        int pivot = Math.abs((start+end)/2);

        if(Math.abs(start-end) == 1) {

            for (int i = 0; i<=end; i++) {

                if(input[i] == element) {
                    return i;
                }
            }

            return -1;
        }
        if(input[pivot] ==  element) {
            return pivot;
        }else if(element > input[end]) {

            return findElementInSortedArray(input,start,pivot-1,element);
        }else {
            return findElementInSortedArray(input,pivot+1,end,element);
        }
    }
}
