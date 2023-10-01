package fastcampus.실강.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class 최소점프 {

	public int solution(int home) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] isVisited = new boolean[10001]; // 좌표가 0 부터 10,000 까지

		queue.offer(0);
		isVisited[0] = true;
		int level = 0; // 트리 구조로 그려서 생각

		while (!queue.isEmpty()) {
			int n = queue.size();

			for (int i = 0; i < n; i++) {
				int node = queue.poll();

				for (int sum : new int[] {node - 1, node + 1, node + 5}) {
					if (sum == home) {
						return level + 1;
					}
					if (sum >= 0 && sum <= 10000 && !isVisited[sum]) {
						isVisited[sum] = true;
						queue.offer(sum);
					}
				}
			}
			level++;
		}
		return 0;
	}

	public static void main(String[] args) {
		최소점프 T = new 최소점프();
		System.out.println(T.solution(10));
		System.out.println(T.solution(14));
		System.out.println(T.solution(25));
		System.out.println(T.solution(24));
		System.out.println(T.solution(345));
	}
}
