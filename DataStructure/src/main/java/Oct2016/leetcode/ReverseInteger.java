package Oct2016.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by ritesh on 10/16/16.
 */
public class ReverseInteger {

    public static void main(String args[]) {

        int x = 1534236469;

        System.out.print(reverseInterger(x));
    }

    public static int reverseInterger(int x) {

        if(x == 0) {
            return 0;
        }

        long input = x;
        boolean isNegative = false;


        if(x < 0) {

            if(x == Integer.MIN_VALUE) {
                input = Integer.MAX_VALUE;
            }else {
                isNegative = true;
                input = Math.abs(x);
            }
        }

        final Queue<Long> dequeue = new ArrayDeque<>();

        while(input > 0) {

            long remainder = 0;

            remainder = input%10;

            input = input/10;

            dequeue.add(remainder);
        }

        final StringBuilder stringBuilder = new StringBuilder();

        while(!dequeue.isEmpty()) {

            stringBuilder.append(dequeue.remove());
        }

        final String output  =  stringBuilder.toString().trim();

        try {
            if (isNegative) {
                return 0 - Integer.parseInt(output);
            }

            return Integer.parseInt(output);
        }catch(NumberFormatException e) {

            return 0;
        }
    }
}
