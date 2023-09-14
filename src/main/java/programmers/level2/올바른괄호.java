package programmers.level2;

import java.util.Stack;

public class 올바른괄호 {

	public static void main(String[] args) {
		System.out.println(solution(")()("));
		System.out.println(solution("()()"));
	}

	private static boolean solution(String s) {
		Stack<Character> stack = new Stack<>();

		for (char c : s.toCharArray()) {
			if (c == '(') {
				stack.push(c);
			} else {
				if (stack.isEmpty() || stack.pop() == ')') {
					return false;
				}
			}
		}

		return stack.size() <= 0;
	}
}
