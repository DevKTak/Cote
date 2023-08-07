
class Solution {
    
    private static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
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
    
    	private void dfs(int row, int computerCnt, int[][] computers) {
		visited[row] = true;

		for (int col = 0; col < computerCnt; col++) {
			if (computers[row][col] == 1 && !visited[col]) {
				dfs(col, computerCnt, computers);
			}
		}
	}
}