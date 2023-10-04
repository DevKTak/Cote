package fastcampus.인강.그래프.dfs;

public class pro_네트워크 {

	private static boolean[] visited;

	public static void main(String[] args) {
		System.out.println("1번");
		// System.out.println(solution(3, new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}})); // 2
		// System.out.println(solution(3, new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 1, 1}}));
		// System.out.println(solution(3, new int[][] {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}})); // 1
		// System.out.println(solution(3, new int[][] {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}})); // 3
		// System.out.println(solution(3, new int[][] {{0, 0, 1}, {0, 0, 0}, {1, 0, 0}})); // 2
		// System.out.println(solution(3, new int[][] {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}})); // 1
		System.out.println(solution(3, new int[][] {{1, 0, 0}, {1, 1, 0}, {0, 1, 1}}));
		System.out.println(solution(4, new int[][] {{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 0}, {1, 1, 0, 1}}));

	}

	public static int solution(int n, int[][] computers) {
		int cnt = 0;
		visited = new boolean[computers.length];

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				cnt++;

				dfs(i, n, computers);
			}
		}
		return cnt;
	}

	private static void dfs(int row, int computerCnt, int[][] computers) {
		visited[row] = true;

		for (int col = 0; col < computerCnt; col++) {
			if (computers[row][col] == 1 && !visited[col]) {
				dfs(col, computerCnt, computers);
			}
		}
	}
}
