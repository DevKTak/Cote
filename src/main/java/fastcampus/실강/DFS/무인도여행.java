package fastcampus.실강.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 무인도여행 {

	public static void main(String[] args) {
		무인도여행 T = new 무인도여행();
		// System.out.println(Arrays.toString(solution(new String[] {"X591X", "X1X5X", "X231X", "1XXX1"})));
		System.out.println(Arrays.toString(T.solution(new String[] {"XXX", "XXX", "XXX"})));
	}

	int sum;
	int[] dr = {-1, 0, 1, 0};
	int[] dc = {0, 1, 0, -1};

	public int[] solution(String[] maps) {
		char[][] board = new char[maps.length][maps[0].length()];

		for (int i = 0; i < maps.length; i++) {
			board[i] = maps[i].toCharArray();
		}
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] != 'X') {
					sum = 0;
					dfs(i, j, board);
					list.add(sum);
				}
			}
		}
		// list.sort((a, b) -> a - b);
		// list.sort(Comparator.comparingInt(a -> a));
		return list.isEmpty() ? new int[] {-1} : list.stream().mapToInt(v -> v).sorted().toArray();
	}

	private void dfs(int r, int c, char[][] board) {
		sum += board[r][c] - 48;
		board[r][c] = 'X';

		for (int i = 0; i < 4; i++) {
			int nr = dr[i] + r;
			int nc = dc[i] + c;

			if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length) {
				if (board[nr][nc] != 'X') {
					dfs(nr, nc, board);
				}
			}
		}
	}
}
