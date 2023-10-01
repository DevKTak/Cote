package fastcampus.실강.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class 미로의최단거리통로 {

	public int solution(int[][] board) {
		// 12시, 3시, 6시, 9시 (상우하좌)
		int dr[] = {-1, 0, 1, 0}; // row
		int dc[] = {0, 1, 0, -1}; // column

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {0, 0});
		int level = 0; // 시작이 0이기 때문

		while (!queue.isEmpty()) {
			int len = queue.size();

			for (int i = 0; i < len; i++) {
				int[] node = queue.poll();

				for (int j = 0; j < 4; j++) {
					int sumDr = node[0] + dr[j];
					int sumDc = node[1] + dc[j];

					if (sumDr == 6 && sumDc == 6) {
						return level + 1;
					}
					if (0 <= sumDr && sumDr < 7 && 0 <= sumDc && sumDc < 7 && board[sumDr][sumDc] == 0) {
						board[sumDr][sumDc] = 1;
						queue.offer(new int[] {sumDr, sumDc});
					}
				}
			}
			level++;
		}
		return -1;
	}

	class Pair {

		private int row;
		private int column;

		Pair(int row, int column) {
			this.row = row;
			this.column = column;
		}

		public int getRow() {
			return this.row;
		}

		public int getColumn() {
			return this.column;
		}
	}

	public int solution2(int[][] board) {
		// 12시, 3시, 6시, 9시 (상우하좌)
		int dr[] = {-1, 0, 1, 0}; // row
		int dc[] = {0, 1, 0, -1}; // column

		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(0, 0));
		int level = 0; // 시작이 0이기 때문

		while (!queue.isEmpty()) {
			int len = queue.size();

			for (int i = 0; i < len; i++) {
				Pair pair = queue.poll();

				for (int j = 0; j < 4; j++) {
					int nr = pair.getRow() + dr[j];
					int nc = pair.getColumn() + dc[j];

					if (nr == 6 && nc == 6) {
						return level + 1;
					}
					if (0 <= nr && nr < 7 && 0 <= nc && nc < 7 && board[nr][nc] == 0) {
						board[nr][nc] = 1;
						queue.offer(new Pair(nr, nc));
					}
				}
			}
			level++;
		}
		return -1;
	}

	public static void main(String[] args) {
		미로의최단거리통로 T = new 미로의최단거리통로();
		int[][] arr = {{0, 0, 0, 0, 0, 0, 0},
			{0, 1, 1, 1, 1, 1, 0},
			{0, 0, 0, 1, 0, 0, 0},
			{1, 1, 0, 1, 0, 1, 1},
			{1, 1, 0, 1, 0, 0, 0},
			{1, 0, 0, 0, 1, 0, 0},
			{1, 0, 1, 0, 0, 0, 0}};
		// System.out.println(T.solution(arr));
		System.out.println(T.solution2(arr));
	}
}
