package fastcampus.실강.DFS;

public class 검정색영역구하기_DFS {

	int answer;

	// 12, 3, 6, 9
	int[] dr = {-1, 0, 1, 0};
	int[] dc = {0, 1, 0, -1};

	public void DFS(int r, int c, int[][] board) {
		board[r][c] = 0;

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length) { // board 범위 내부
				if (board[nr][nc] == 1) {
					DFS(nr, nc, board);
				}
			}
		}
	}

	public int solution(int[][] board) {
		answer = 0;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 1) {
					answer++;

					DFS(i, j, board);
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		검정색영역구하기_DFS T = new 검정색영역구하기_DFS();
		System.out.println(T.solution(
			new int[][] {{0, 1, 1, 0, 0}, {0, 1, 1, 0, 0}, {0, 1, 0, 0, 0}, {0, 0, 0, 1, 0}, {0, 0, 1, 1, 0}}));
		System.out.println(T.solution(
			new int[][] {{1, 1, 1, 0, 1}, {1, 1, 1, 0, 1}, {0, 0, 1, 0, 0}, {1, 1, 0, 1, 0}, {1, 0, 1, 0, 0}}));
		System.out.println(T.solution(
			new int[][] {{0, 0, 1, 0, 0}, {0, 1, 1, 0, 0}, {0, 1, 0, 0, 0}, {1, 0, 0, 1, 0}, {0, 0, 1, 1, 0}}));
		System.out.println(T.solution(
			new int[][] {{0, 0, 0, 0, 1}, {0, 0, 1, 0, 0}, {0, 1, 0, 1, 0}, {0, 0, 0, 1, 0}, {0, 0, 1, 0, 0}}));
	}
}
