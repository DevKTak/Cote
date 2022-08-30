package leetcode;

import java.util.Stack;

public class Leet_20_Valid_Parentheses {

    public static void main(String[] args) {
        System.out.println(isValid("["));
    }

    /**
     * 괄호 짝 여부 파악 문제
     */
    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        /*for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();*/

        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
            }
        }

        return stack.isEmpty();
    }
}
