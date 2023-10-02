package fastcampus.실강.DFS;

import java.util.Stack;

/**
 * 10이하의 N개의 자연수가 주어지면
 * 이 중 M개를 뽑아 일렬로 나열하는 방법을 모두 출력합니다.
 */
public class 순열구하기 {

	Stack<Integer> stack = new Stack<>();

	public void DFS(int L, int n, int m, boolean[] ch) {
		if (L == m) {
			for (int val : stack) {
				System.out.print(val + " ");
			}
			System.out.println();
		} else {
			for (int i = 1; i <= n; i++) {
				if (!ch[i]) {
					ch[i] = true;
					stack.push(i);

					DFS(L + 1, n, m, ch);
					ch[i] = false;
					stack.pop();
				}
			}
		}
	}

	public void solution(int n, int m) {
		boolean[] ch = new boolean[n + 1];
		DFS(0, n, m, ch);
	}

	public static void main(String[] args) {
		순열구하기 T = new 순열구하기();
		T.solution(3, 2);
	}
}
