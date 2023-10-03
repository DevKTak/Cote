package fastcampus.실강.그래프;

import java.util.ArrayList;
import java.util.List;

public class 컴퓨터개수_dfs {

	List<List<Integer>> adList = new ArrayList<>();
	boolean[] visited;
	int computerCnt;

	private void dfs(int vertex) {
		visited[vertex] = true;
		computerCnt++;

		for (int ad : adList.get(vertex)) {
			if (!visited[ad]) {
				dfs(ad);
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

		dfs(1);

		return n - computerCnt;
	}

	public static void main(String[] args) {
		컴퓨터개수_dfs T = new 컴퓨터개수_dfs();
		System.out.println(
			T.solution(11, new int[][] {{1, 2}, {1, 4}, {2, 3}, {4, 5}, {5, 6}, {7, 8}, {7, 10}, {8, 9}, {10, 11}}));
	}
}
