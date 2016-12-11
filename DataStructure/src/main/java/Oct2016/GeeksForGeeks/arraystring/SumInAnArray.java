package Oct2016.GeeksForGeeks.arraystring;

/**
 * Check for pair in a given array.
 * Created by ritesh on 11/16/16.
 */
public class SumInAnArray {

    public static void main(String args[]) {

        int input[] = new int[]{3,9,14,17,19,20,23,43};

        int[] ints = pairInAnArray(input, 0, input.length - 1, 43);

        for (int value : ints) {
            System.out.println(value);
        }
    }

    // working solution
    public static int[] pairInAnArray(int input[], int start, int end, int x) {

        if(start>end) {
            return new int[] {0,0};
        }

        if(Math.abs(start-end) == 2) {

            if(input[start] + input[end] == x) {
                 return new int[] {input[start], input[end]};
            }else {

                for(int i=start;i<=end;i++) {
                    for (int j = i+1; j <=end; j++) {

                        if(input[i] +input[j] == x) {
                            return new int[] {input[i], input[j]};
                        }
                    }
                }
            }

            return new int[] {0,0};
        }

        int pivot = (start + end)/2;

        int side = Math.abs(x - input[pivot]);

        if(side > input[pivot]) {
            return pairInAnArray(input,pivot,end,x);
        }

        if(side<input[pivot]) {
            return pairInAnArray(input,start,pivot-1,x);
        }

        return new int[] {0,0};
    }
}
