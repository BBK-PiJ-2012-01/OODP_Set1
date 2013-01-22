package q15;

import java.util.Stack;

/**
 * User: Sam Wright
 * Date: 22/01/2013
 * Time: 14:30
 */
public class PalindromeTester {
    public boolean isPalindrome(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (char c : s.toCharArray()) {
            stack.push(c);
        }

        StringBuilder sbuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            sbuilder.append(stack.pop());
        }

        return sbuilder.toString().equals(s);
    }
}
