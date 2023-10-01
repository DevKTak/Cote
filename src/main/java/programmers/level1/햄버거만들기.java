package programmers.level1;

import java.util.Stack;

public class 햄버거만들기 {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {2, 1, 1, 2, 3, 1, 2, 3, 1})); // 1, 2, 3, 1(빵, 야채, 고기, 빵)
	}

	private static int solution(int[] ingredient) {
		Stack<Integer> stack = new Stack<>();
		int cnt = 0;

		for (int in : ingredient) {
			stack.push(in);

			if (stack.size() >= 4) {
				if (stack.get(stack.size() - 1) == 1
					&& stack.get(stack.size() - 2) == 3
					&& stack.get(stack.size() - 3) == 2
					&& stack.get(stack.size() - 4) == 1) {
					cnt++;

					for (int i = 0; i < 4; i++) {
						stack.pop();
					}
				}
			}
		}
		return cnt;
	}
}
