package third;

/**
 * Created by ridima on 10/1/16.
 */

import java.util.HashMap;
import java.util.Stack;


public class StringValidation {

    public boolean isValidString(String s) {

        if(s.length() < 1) {
            throw new IllegalArgumentException("Empty string not excepted");
        }
        HashMap<Character,Character> paranthesis = new HashMap<Character,Character>();
        paranthesis.put('[',']');
        paranthesis.put('{','}');
        paranthesis.put('(',')');

        Stack<Character> stack = new Stack<Character>();
        for(int i =0; i<s.length(); i++) {
            char current = s.charAt(i);
            if(paranthesis.containsKey(current)) {
                stack.push(current);
            } else if(paranthesis.containsValue(current)) {
                for(Object o : paranthesis.keySet()) {
                    if((paranthesis.get(o).equals(current)) && !stack.isEmpty()) {
                        stack.pop();
                    }
                }
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        StringValidation stringValidation = new StringValidation();
        if(stringValidation.isValidString("")) {
            System.out.println("Valid String");
        } else {
            System.out.println("Invalid String");
        }
    }
}

