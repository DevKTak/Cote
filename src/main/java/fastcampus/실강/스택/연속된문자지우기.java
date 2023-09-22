package fastcampus.실강.스택;

import java.util.Stack;

public class 연속된문자지우기 {

	public String solution(String s) {
		Stack<Character> stack = new Stack<>();

		for (char c : s.toCharArray()) {
			if (!stack.isEmpty() && stack.peek() == c) {
				stack.pop();

				continue;
			}
			stack.push(c);
		}
		StringBuilder sb = new StringBuilder();

		for (char c : stack) {
			sb.append(c);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		연속된문자지우기 T = new 연속된문자지우기();
		System.out.println(T.solution("acbbcaa"));
		System.out.println(T.solution("bacccaba"));
		System.out.println(T.solution("aabaababbaa"));
		System.out.println(T.solution("bcaacccbaabccabbaa"));
		System.out.println(T.solution("cacaabbc"));
	}
}
