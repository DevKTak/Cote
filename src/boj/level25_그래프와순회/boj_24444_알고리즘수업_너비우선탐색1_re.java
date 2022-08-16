package boj.level25_그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_24444_알고리즘수업_너비우선탐색1_re {

    private static List<Integer>[] adList;
    private static boolean[] visited;
    private static int[] order;
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        adList = new ArrayList[N + 1]; // 배열 초기화
        visited = new boolean[N + 1];
        order = new int[N];

        for (int i = 1; i <= M; i++) {
            adList[i] = new ArrayList<>(); // List 초기화
        }

        int u;
        int v;

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            adList[u].add(v);
            adList[v].add(u);
        }

        for (int i = 1; i <= N ; i++) {
            Collections.sort(adList[i]);
        }

        bfs(R);

        Arrays.stream(order).forEach((a) -> System.out.println(a));
    }

    public static void bfs(int R) {
        Queue<Integer> q = new LinkedList();
        q.offer(R);
        visited[R] = true;

        while (!q.isEmpty()) {
            int poll = q.poll();
            order[poll - 1] = ++cnt;

            for (int ad : adList[poll]) {
                if (!visited[ad]) {
                    q.offer(ad);
                    visited[ad] = true;
                }
            }
        }
    }
}
