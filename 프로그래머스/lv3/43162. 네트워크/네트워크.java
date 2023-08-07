
class Solution {
    
    private static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
  int answer;
		int tmp = 0;
		for (int i = 0; i < computers.length; i++) {
			for (int j = 0; j < computers.length; j++) {
				// tmp = dfs(tmp, computers, i, j);
				if (i != j && computers[i][j] == 1 && computers[j][i] == 1) {
					tmp++;
				}
			}
		}
		tmp /= 2;
		if (tmp == n) {
			return 1;
		} else {
			n -= tmp;
			answer = n;
		}
		return answer;
	}
}