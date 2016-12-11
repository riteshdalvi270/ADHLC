package Oct2016.stringarrays;

/**
 * Created by ritesh on 10/23/16.
 */
public class StringCompression {

    public static void main(String args[]) {

        final String input = "abc";

        System.out.println(stringCompression(input));
    }

    public static String stringCompression(final String input) {

        final StringBuilder output = new StringBuilder();

        for(int i = 0; i<input.length(); i++) {

            int count = 0;

            if(i+1 >= input.length()) {

                output.append(input.charAt(i));
                output.append(++count);
            }

            for(int j=i+1; j<input.length(); j++) {

                if(input.charAt(i) == input.charAt(j)) {

                    count = count + 1;
                }else {

                    count = count + 1;

                    output.append(input.charAt(i));
                    output.append(count);

                    i = j-1;
                    break;
                }
            }
        }

        if(output.length() < input.length()) {
            return input;
        }

        return output.toString();
    }
}
