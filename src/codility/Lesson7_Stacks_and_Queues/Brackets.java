package codility.Lesson7_Stacks_and_Queues;

import java.util.Stack;

public class Brackets {

    public static void main(String[] args) {
        System.out.println(solution("{[()()]}"));
        System.out.println(solution("{[())]}"));
        System.out.println(solution("{[]()[]{}}"));
        System.out.println(solution("{)"));
    }

    /**
     * 괄호 짝 여부 파악 문제
     */
    private static int solution(String S) {
//        if (S.equals("")) return 1;
//        if (S.length() == 0) return 1;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            char curEl = S.charAt(i);
            switch (curEl) {
                case '(':
                case '{':
                case '[':
                    stack.push(curEl);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return 0;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return 0;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return 0;
                    }
                    break;
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
