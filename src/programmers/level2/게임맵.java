package programmers.level2;

import java.util.*;

class 게임맵 {

    static boolean[][] chk;
    static int[] diry = {-1, 0, 1, 0};//상 우 하 좌
    static int[] dirx = {0, 1, 0, -1};
    // static int[][] map;
    static int n;
    static int m;

    public class Node {
        int x;
        int y;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public int solution(int[][] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length;
        chk = new boolean[n][m];

        chk[0][0] = true;
        bfs(0, 0, maps);

        answer = maps[n - 1][m - 1];
        return answer > 1 ? answer : -1;
    }

//     private static void bfs(int y, int x) {

    //     }
    public void bfs(int y, int x, int[][] maps) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(y, x));

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int now_y = now.y + diry[i];
                int now_x = now.x + dirx[i];
                if (0 <= now_y && now_y < n && 0 <= now_x && now_x < m) {
                    if (maps[now_y][now_x] != 0 && !chk[now_y][now_x]) {
                        queue.add(new Node(now_y, now_x));
                        chk[now_y][now_x] = true;
                        maps[now_y][now_x] = maps[now.y][now.x] + 1;
                    }
                }
            }
        }
    }


}