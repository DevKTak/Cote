package fastcampus.실강.DFS;

import java.util.Stack;

// NHN 3번 문제
public class 줄다리기 {

	int answer;
	boolean[][] adArr;
	boolean[] visited;
	Stack<Integer> stack;

	public void DFS(int L) {
		if (L == 7) {
			answer++;
		} else {
			for (int i = 1; i <= 7; i++) {
				if (!visited[i]) { // 방문한적 없으면

					// 서로 싫어하는 학생이랑 이웃이면 더이상 진행할 필요가 없다. (인접행렬 사용)
					if (!stack.isEmpty() && adArr[stack.peek()][i]) {
						continue;
					}
					visited[i] = true;
					stack.push(i);

					DFS(L + 1);
					visited[i] = false;
					stack.pop();
				}
			}
		}
	}

	public int solution(int[][] fight) {
		answer = 0;
		adArr = new boolean[8][8]; // 인접행렬
		visited = new boolean[8]; // 방문여부
		stack = new Stack<>(); // 학생 줄세우기

		// 인접행렬 만들기
		for (int[] arr : fight) {
			adArr[arr[0]][arr[1]] = true;
			adArr[arr[1]][arr[0]] = true;
		}
		DFS(0);

		return answer;
	}

	public static void main(String[] args) {
		줄다리기 T = new 줄다리기();
		System.out.println(T.solution(new int[][] {{1, 3}, {5, 7}, {4, 2}}));
		System.out.println(T.solution(new int[][] {{3, 2}, {3, 5}, {5, 2}, {7, 3}}));
		System.out.println(T.solution(new int[][] {{1, 2}, {1, 5}, {1, 7}, {1, 3}}));
		System.out.println(T.solution(new int[][] {{1, 7}}));
		System.out.println(T.solution(new int[][] {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
	}
}
