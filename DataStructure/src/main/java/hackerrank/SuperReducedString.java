package hackerrank;

import java.util.Scanner;

/**
 * Created by ritesh on 9/4/16.
 */
public class SuperReducedString {

    public static void main(String[] args) {

        final Scanner in = new Scanner(System.in);

        String input = in.nextLine();

        final StringBuilder output = new StringBuilder(input);

        for(int i=1;i<output.length();i++) {

            if(output.charAt(i) == output.charAt(i-1)) {
                output.delete(i-1,i+1);
                i=0;
            }
        }

        String purchase = "hello:world";
        String[] split = purchase.split(":");

        if(output.length() == 0) {
            System.out.println("Empty String");
        }else {
            System.out.println(output.toString());
        }

    }
}
