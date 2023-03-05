package com.greatlearning.iitr.dsa.labsession3;
import java.util.*;

public class Balanced {
	public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string of brackets: ");
        String input = scanner.nextLine();
        
        if (isBalanced(input)) {
            System.out.println("The entered string has balanced brackets.");
        } else {
            System.out.println("The entered string does not have balanced brackets.");
        }
    }
    
    public static boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false;
                } else if ((c == ')' && stack.peek() == '(') || 
                           (c == ']' && stack.peek() == '[') || 
                           (c == '}' && stack.peek() == '{')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
