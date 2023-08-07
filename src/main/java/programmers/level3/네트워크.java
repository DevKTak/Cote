package programmers.level3;

public class 네트워크 {

    public static void main(String[] args) {
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }

    private static int solution(int n, int[][] computers) {
        int cnt = 0;
        boolean[] visited = new boolean[computers.length];

        for (int i = 0; i < n; i++) { // 1 번 컴퓨터부터 방문 시작
            if (!visited[i]) {
                dfs(i, computers, visited);
                cnt++;
            }
        }

        return cnt;
    }

    private static void dfs(int i, int[][] computes, boolean[] visited) {
//        if (visited[i]) {
//            return;
//        }
        visited[i] = true;
        System.out.println(i + " ");

        for (int j = 0; j < computes[i].length; j++) {
            if (computes[i][j] == 1 && /*i != j*/ !visited[j]) {
                dfs(j, computes, visited);
            }
        }
    }
}













