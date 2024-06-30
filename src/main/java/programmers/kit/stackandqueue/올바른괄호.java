package programmers.kit.stackandqueue;

import java.util.Stack;

public class 올바른괄호 {

	public static void main(String[] args) {
		System.out.println(solution("()()"));
	}

	static boolean solution(String s) {
		Stack<Character> stack = new Stack<>();
		char[] chars = s.toCharArray();

		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '(') {
				stack.push(chars[i]);
			} else {
				if (stack.isEmpty()) {
					return false;
				} else {
					stack.pop();
				}
			}
		}
		return stack.isEmpty();
	}
}
