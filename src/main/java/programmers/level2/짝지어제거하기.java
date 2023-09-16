package programmers.level2;

import java.util.Stack;

public class 짝지어제거하기 {

	public static void main(String[] args) {
		// String s = "baabaac";
		String s = "baabaa";
		System.out.println(solution(s));
		System.out.println(solution_re(s));
	}

	private static int solution(String s) {
    /* 시간 초과
    StringBuilder sb = new StringBuilder(s);

    for (int i = 0; i < sb.length() - 1; i++) {
      if (sb.charAt(i) == sb.charAt(i + 1)) {
        sb.delete(i, i + 2);
        i = -1;
      }
    }

    return sb.length() > 0 ? 0 : 1;
    */

		Stack<Character> st = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if (st.isEmpty()) {
				st.push(s.charAt(i));
			} else {
				if (st.peek() == s.charAt(i)) {
					st.pop();
				} else {
					st.push(s.charAt(i));
				}
			}
		}

		return st.isEmpty() ? 1 : 0;
	}

	private static int solution_re(String s) {
		Stack<Character> stack = new Stack<>();
		char[] chars = s.toCharArray();

		for (char c : chars) {
			if (!stack.isEmpty() && stack.peek() == c) {
				stack.pop();
			} else {
				stack.push(c);
			}
		}
		return stack.isEmpty() ? 1 : 0;
	}
}
