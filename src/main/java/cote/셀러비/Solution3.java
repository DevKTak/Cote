package cote.셀러비;

import java.util.Stack;

public class Solution3 {

	public static void main(String[] args) {
		Solution3 P = new Solution3();
		System.out.println(P.solution("(()()()")); // 7
	}

	public int solution(String s) {
		int answer = 0;
		String[] arr = new String[] {"(", ")", "{", "}", "[", "]"};

		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < arr.length; j++) {
				String inserted = s.substring(0, i) + arr[j] + s.substring(i);

				if (isValid(inserted)) {
					answer++;
				}
			}
		}
		return answer;
	}

	private boolean isValid(String inserted) {
		Stack<Character> stack = new Stack<>();

		for (char c : inserted.toCharArray()) {
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
				stack.pop();
			} else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
				stack.pop();
			} else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
				stack.pop();
			} else {
				return false;
			}
		}
		return stack.isEmpty();
	}
}
