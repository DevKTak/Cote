package boj.level25_그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_24444_알고리즘수업_너비우선탐색1 {

    private static List<Integer>[] adList;
    private static boolean[] visited;
    private static int[] order;
    private static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        adList = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        order = new int[N];

        for (int i = 1; i <= N; i++) {
            adList[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            adList[start].add(end);
            adList[end].add(start);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(adList[i]);
        }

        bfs(R);

        Arrays.stream(order).forEach(System.out::println);
    }

    private static void bfs(int R) {
        Queue<Integer> q = new LinkedList();
        q.offer(R);
        visited[R] = true;

        while (!q.isEmpty()) {
            int num = q.poll();
            order[num - 1] = ++cnt;

            for (int ad : adList[num]) {
                if (!visited[ad]) {
                    visited[ad] = true;
                    q.offer(ad);
                }
            }
        }
    }
}
