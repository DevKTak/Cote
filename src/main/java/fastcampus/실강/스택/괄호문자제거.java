package fastcampus.실강.스택;

import java.util.Stack;

public class 괄호문자제거 {

	public String solution(String str) {
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();

		for (char c : str.toCharArray()) {
			if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				stack.pop();
			} else {
				if (stack.isEmpty()) {
					sb.append(c);
				}
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		괄호문자제거 T = new 괄호문자제거();
		System.out.println(T.solution("(A(BC)D)EF(G(H)(IJ)K)LM(N)")); // EFLM
	}
}
