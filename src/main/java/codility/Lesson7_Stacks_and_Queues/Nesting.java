package codility.Lesson7_Stacks_and_Queues;

import java.util.Stack;

public class Nesting {

    public static void main(String[] args) {
        System.out.println(solution("(()(())())"));
        System.out.println(solution("())"));
        System.out.println(solution(")"));
        System.out.println(solution(")(("));
        System.out.println(solution(""));
    }

    /**
     * 괄호 짝 여부 파악 문제
     */
    public static int solution(String S) {
        Stack<Character> stack = new Stack<>();

        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || stack.pop() == ')') {
                    return 0;
                }
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
