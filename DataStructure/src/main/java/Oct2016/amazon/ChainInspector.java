package Oct2016.amazon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ChainInspector {

    public static void main(String args[]) {

        final Scanner scanner = new Scanner(System.in);

        System.out.println(validateChainInspector(scanner.nextLine()));
    }

    /**
     * eg input: 4-2;BEGIN-3;3-4;2-END
     * Output: Good
     * Validates a chain inspector.
     * @param input The chain of element (cannot be null).
     * @return Good, if the chain inspection is valid, Bad otherwise.
     */
    public static String validateChainInspector(final String input) {

        final String[] nameAddress = input.split(";");

        final Map<String,String> addressByName = new HashMap<>();

        for(final String entry : nameAddress) { // n

            final String[] values = entry.split("-");

            addressByName.put(values[0], values[1]);
        }

        final boolean[] ascii = new boolean[128];
        int end = 0;
        int begin = 0;

        for(final Map.Entry<String,String> entrySet : addressByName.entrySet()) {

            String name =  entrySet.getKey();
            String address = entrySet.getValue();

            //Avoid left out pair and loop.
            if(name.equals(address)) {
                return "BAD";
            }

            // Avoid left out pairs (whos name and address is not the same)
            String hashNameValue = addressByName.get(address);
            if(hashNameValue == null && !address.equals("END")) {
                return "BAD";
            }

            String hashAddressValue = addressByName.get(name);
            // If name-address pair is in a loop.
            if(hashAddressValue!=null && !hashAddressValue.equals("END")) {

                if(ascii[Integer.parseInt(hashAddressValue)]) {
                    return "BAD";
                }
            }

            if(address.equals("END")) {
                end = end + 1;
            }else {
                int addressConversion = Integer.parseInt(address);
                ascii[addressConversion] =  true;
            }

            if(name.equals("BEGIN")) {
                begin = begin + 1;
            }
        }

        if(end!=1 || begin!=1) {
            return "BAD";
        }

        return "GOOD";
    }
}
