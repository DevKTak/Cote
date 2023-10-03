package fastcampus.실강.그래프;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 컴퓨터개수_bfs {

	List<List<Integer>> adList = new ArrayList<>();
	boolean[] visited;
	int computerCnt;

	private void bfs(int vertex) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(vertex);
		visited[vertex] = true;

		while (!queue.isEmpty()) {
			computerCnt++;
			int curVertex = queue.poll();

			for (int ad : adList.get(curVertex)) {
				if (!visited[ad]) {
					visited[ad] = true;
					queue.offer(ad);
				}
			}
		}
	}

	public int solution(int n, int[][] edge) {
		for (int i = 0; i <= n; i++) {
			adList.add(new ArrayList<>());
		}
		for (int[] arr : edge) {
			adList.get(arr[0]).add(arr[1]);
			adList.get(arr[1]).add(arr[0]);
		}
		visited = new boolean[n + 1];
		computerCnt = 0;

		bfs(1);

		return n - computerCnt;
	}

	public static void main(String[] args) {
		컴퓨터개수_bfs T = new 컴퓨터개수_bfs();
		System.out.println(
			T.solution(11, new int[][] {{1, 2}, {1, 4}, {2, 3}, {4, 5}, {5, 6}, {7, 8}, {7, 10}, {8, 9}, {10, 11}}));
	}
}
