package fastcampus.실강.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class 검정색영역구하기_BFS {

	int answer;

	// 12, 3, 6, 9
	int[] dr = {-1, 0, 1, 0};
	int[] dc = {0, 1, 0, -1};

	static class Pair {

		int r;
		int c;

		Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}

		public int getR() {
			return r;
		}

		public int getC() {
			return c;
		}
	}

	public void BFS(int r, int c, int[][] board) {
		board[r][c] = 0; // 방문 처리
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(r, c));

		while (!queue.isEmpty()) {
			Pair pair = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nr = pair.getR() + dr[i];
				int nc = pair.getC() + dc[i];

				if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length) {
					if (board[nr][nc] == 1) {
						board[nr][nc] = 0; // 방문 처리
						queue.offer(new Pair(nr, nc));
					}
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

					BFS(i, j, board);
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		검정색영역구하기_BFS T = new 검정색영역구하기_BFS();
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
