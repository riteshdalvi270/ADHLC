package hackerrank;

import java.util.Scanner;

/**
 * Created by ritesh on 9/6/16.
 */
public class Palidrome {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String number = in.next();

        final StringBuilder output = new StringBuilder(number);

        int j = number.length()-1;
        int i =0;
        boolean isPalidrome = false;
        int d = k;

        while(i<j) {

            char a = output.charAt(i);
            char b = output.charAt(j);

            if(k!=0) {
                isPalidrome = true;

                if(a!=b) {
                    if(a=='9') {
                        output.setCharAt(j,a);
                    }else if(b=='9') {
                        output.setCharAt(i,b);
                    }else {
                        output.setCharAt(i, '9');
                        output.setCharAt(j, '9');
                    }

                    k--;
                }
            }else {
                if(a!=b) {
                    isPalidrome = false;
                }else {
                    isPalidrome = true;
                }
            }

            i++;
            j--;
        }

        if(isPalidrome) {
            System.out.println(output.toString());
        }else {
            System.out.println(-1);
        }
    }
}
