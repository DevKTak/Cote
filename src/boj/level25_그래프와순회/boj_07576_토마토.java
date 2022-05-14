    package boj.level25_그래프와순회;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.LinkedList;
    import java.util.Queue;
    import java.util.StringTokenizer;

    /**
     * 토마토
     * visited[][] 변수가 따로 필요없는 BFS 문제
     */
    public class boj_07576_토마토 {

        private static int M, N;
        private static int[][] map;
        private static Queue<Pair> queue = new LinkedList<>();
        private static int[] dx = {-1, 1, 0, 0};
        private static int[] dy = {0, 0, -1, 1};
        private static int cnt;


        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken()); // 열
            N = Integer.parseInt(st.nextToken()); // 행
            map = new int[N][M];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());

                    // 동시에 여러곳에서 시작 할 수 있기 때문에 큐에 다 넣는 작업
                    if (map[i][j] == 1) {
                        queue.offer(new Pair(i, j));
                    }
                }
            }

            bfs();
            System.out.println(result());

        }

        private static int result() {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 0) {
                        return -1; // 토마토가 모두 익지 못하는 상황
                    } else if (map[i][j] > 2) {
                        return cnt - 1; // 1 부터 시작했기 때문에 -1 해줌
                    }
                }
            }

            return 0; // 저장될 때부터 모든 토마토가 익어있는 상태
        }

        private static void bfs() {
            while (!queue.isEmpty()) {
                Pair pair = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int xSum = pair.x + dx[i];
                    int ySum = pair.y + dy[i];

                    if (0 <= xSum && xSum < N && 0 <= ySum && ySum < M) {
                        if (map[xSum][ySum] == 0) {
                            cnt = map[xSum][ySum] = map[pair.x][pair.y] + 1;
                            queue.offer(new Pair(xSum, ySum));
                        }
                    }
                }
            }
        }

        private static class Pair {

            int x;
            int y;

            Pair(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
    }
