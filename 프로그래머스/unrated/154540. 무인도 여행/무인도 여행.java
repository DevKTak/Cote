import java.util.*;

class Solution {
    
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
		list.sort((a, b) -> a - b);
		// list.sort(Comparator.comparingInt(a -> a));
		int[] answer = new int[list.size()];

		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		return list.size() == 0 ? new int[] {-1} : answer;

		// return list.isEmpty() ? new int[] {-1} : list.stream().mapToInt(v -> v).sorted().toArray();
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