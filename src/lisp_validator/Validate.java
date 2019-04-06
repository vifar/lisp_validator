package lisp_validator;

import java.util.Scanner;
import java.util.Stack;

public class Validate {

    public static void main(String[] args) {

        //Take in LISP string for validation
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the string you would like to validate: ");
        String testString = input.nextLine();
        System.out.println("Validating...");
        System.out.println("Result of validation : " + validator(testString));
        input.close();
        
    }

    public static boolean validator(String input) {

        //Convert to character array to easily loop
        char[] lispString = input.toCharArray();
        
        //Will use stack for Last in First Out (LIFO)
        Stack<Character> stack = new Stack<Character>();

        //Character by character go through char array
        for(char c : lispString) {
            if(c == '(') {
                stack.push(c);
            } else if(c == ')') {
                if(stack.isEmpty()) {
                    return false;
                } else if(stack.peek() == '(') {
                    stack.pop();
                } else return false;
            }
        }

        return stack.isEmpty();
    }
}
