package third;

import java.util.HashMap;
import java.util.Scanner;

public class Paranthesis {

    public static void main(String args[]) {

        while(true) {

            System.out.println("----Welcome----");
            System.out.println("***Please enter the case input***");
            System.out.println("1: Enter the String");
            System.out.println("2: Quit the program");

            final Scanner input = new Scanner(System.in);

            System.out.println("Case number:");
            int caseNumber = input.nextInt();

            input.nextLine();

            switch (caseNumber) {

                case 1:

                    System.out.println("Enter the String:");

                    final String inputValue = input.nextLine();

                    long startTime = System.currentTimeMillis();

                    if (isValidString(inputValue)) {
                        System.out.print("Valid String: "+inputValue);
                    } else {
                        System.out.print("Invalid String: "+ inputValue);
                    }

                    long estimatedTime = System.currentTimeMillis() - startTime;

                    System.out.println(" Estimated:" + estimatedTime);

                    break;

                case 2:
                    System.exit(0);
                    break;

                default:
                    throw new IllegalArgumentException("Case not supported, please rerun the program");
            }
        }
    }

    /**
     * Determines if the input string has correct opening and closing parathesis.
     * @param value The input string value (cannot be null).
     * @return true if the input string has correct opening and closing paranthesis, false otherwise.
     * @throws RuntimeException if the input string is null.
     */
    public static boolean isValidString(final String value) {

        if(value == null) {
            throw new RuntimeException("Null string not supported");

        }

        if(value.trim().isEmpty()) {
            return true;
        }

        final HashMap<Character,Integer> countOfBracketsCharacter = new HashMap<>();

        for(int i = 0; i<value.length(); i++) {

            final Character character =  value.charAt(i);

            if(character == '(' || character == '[' || character == '{') {

                if(countOfBracketsCharacter.containsKey(character)) {
                    Integer countValue = countOfBracketsCharacter.get(character);
                    countValue++;
                    countOfBracketsCharacter.put(character, countValue);
                }else {
                    int countValue = 0;
                    countValue = countValue + 1;
                    countOfBracketsCharacter.put(character, countValue);
                }
            }else if(character == ')' || character == ']' || character=='}'){

                if(character ==  ')') {
                     final Character openingBracket = '(';
                    if(countOfBracketsCharacter.containsKey(openingBracket)) {
                        updateCountOfBrackets(countOfBracketsCharacter,openingBracket);
                    }else {
                        // encountered closing bracket but not opening.
                        return false;
                    }
                }

                if(character ==  ']') {
                    final Character openingBracket = '[';
                    if(countOfBracketsCharacter.containsKey(openingBracket)) {
                        updateCountOfBrackets(countOfBracketsCharacter,openingBracket);
                    }else {
                        // encountered closing bracket but not opening.
                        return false;
                    }
                }

                if(character ==  '}') {
                    final Character openingBracket = '{';
                    if(countOfBracketsCharacter.containsKey(openingBracket)) {
                        updateCountOfBrackets(countOfBracketsCharacter,openingBracket);
                    }else {
                        // encountered closing bracket but not opening.
                        return false;
                    }
                }
            }
        }

        if(countOfBracketsCharacter.isEmpty()) {
            return true;
        }else {
            for(Integer values : countOfBracketsCharacter.values()) {

                if(values ==  0) {
                    return true;
                }else {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Update the count of the brackets.
     * @param countOfBracketsByAsciiValue count of the brackets by character bracket.
     * @param openingBracket the opening bracket for which count has to be updated.
     */
    private static void updateCountOfBrackets(final HashMap<Character,Integer> countOfBracketsByAsciiValue, final Character openingBracket) {
        Integer count = countOfBracketsByAsciiValue.get(openingBracket);
        count = count -1;
        countOfBracketsByAsciiValue.put(openingBracket,count);
    }
}
