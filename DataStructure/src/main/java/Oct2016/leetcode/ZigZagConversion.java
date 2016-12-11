package Oct2016.leetcode;

/**
 * Created by ritesh on 10/16/16.
 */
public class ZigZagConversion {

    public static void main(String args[]) {

        final String input = "PAYPALISHIRING";
        System.out.println(convert(input,3));
    }

    //Wrong solution
    public static String convert(final String input, int rows) {

        int m = 0;

        int i = 0;

        final Character[][] matrix = new Character[input.length()][rows];

        final Character[] extraCharacter = new Character[input.length()];

        int extraCharacterCount = 0;

        while(i<input.length()) {

            String subString = null;
            if(i+rows < input.length()) {
               subString  = input.substring(i, i + rows);
            }else {
                subString = input.substring(i, input.length());
            }


            for(int n = 0; n<subString.length(); n++) {

                matrix[m][n] = subString.charAt(n);
            }

            m = m + 1;

            i = i + rows;

            if(i < input.length()) {
                extraCharacter[extraCharacterCount] = input.charAt(i);
            }

            i++;
        }

        final StringBuilder output = new StringBuilder();

        for(int a=0;a<matrix.length;a++) {

            for(int b = 0; b<matrix[0].length; b++) {

                output.append(matrix[b][a]);
            }

            output.append(extraCharacter[a]);
        }

        return output.toString();
    }
}
