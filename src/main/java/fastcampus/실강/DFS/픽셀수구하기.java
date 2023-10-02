package fastcampus.실강.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 픽셀수구하기 {

	int[] dr = {-1, 0, 1, 0};
	int[] dc = {0, 1, 0, -1};
	List<Integer> result;
	int cnt = 0;

	public void DFS(int r, int c, int[][] board) {
		board[r][c] = 0;
		cnt++;

		for (int i = 0; i < 4; i++) {
			int nr = dr[i] + r;
			int nc = dc[i] + c;

			if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length) {
				if (board[nr][nc] == 1) {
					DFS(nr, nc, board);
				}
			}
		}
	}

	public int[] solution(int[][] board) {
		result = new ArrayList<>();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 1) {
					DFS(i, j, board);
					result.add(cnt);
					cnt = 0;
				}
			}
		}
		return result.stream().mapToInt(Integer::intValue).toArray();
	}

	public static void main(String[] args) {
		픽셀수구하기 T = new 픽셀수구하기();
		System.out.println(
			Arrays.toString(T.solution(
				new int[][] {{0, 1, 1, 0, 0}, {0, 1, 1, 0, 0}, {0, 1, 0, 0, 0}, {0, 0, 0, 1, 0}, {0, 0, 1, 1, 0}})));
		System.out.println(Arrays.toString(T.solution(
			new int[][] {{1, 1, 1, 0, 1}, {1, 1, 1, 0, 1}, {0, 0, 1, 0, 0}, {1, 1, 0, 1, 0}, {1, 0, 1, 0, 0}})));
		System.out.println(Arrays.toString(T.solution(
			new int[][] {{0, 0, 1, 0, 0}, {0, 1, 1, 0, 0}, {0, 1, 0, 0, 0}, {1, 0, 0, 1, 0}, {0, 0, 1, 1, 0}})));
		System.out.println(Arrays.toString(T.solution(
			new int[][] {{0, 0, 0, 0, 1}, {0, 0, 1, 0, 0}, {0, 1, 0, 1, 0}, {0, 0, 0, 1, 0}, {0, 0, 1, 0, 0}})));
	}
}
