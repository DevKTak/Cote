package fastcampus.실강.DFS;

import java.util.Stack;

/**
 * 1부터 N까지 번호가 적힌 구슬이 있습니다.
 * 이 중 중복을 허락하여 M번을 뽑아 일렬로 나열 하는 방법을 모두 출력합니다.
 */
public class 중복순열 {

	Stack<Integer> stack = new Stack<>();

	public void dfs(int L, int n, int m) {
		if (L == m) {
			for (int val : stack) {
				System.out.print(val + " ");
			}
			System.out.print(System.lineSeparator());
		} else {
			for (int i = 1; i <= n; i++) {
				stack.push(i);

				dfs(L + 1, n, m);

				stack.pop();
			}
		}
	}

	public void solution(int n, int m) {
		dfs(0, n, m);
	}

	public static void main(String[] args) {
		중복순열 T = new 중복순열();
		T.solution(3, 2);
	}
}
