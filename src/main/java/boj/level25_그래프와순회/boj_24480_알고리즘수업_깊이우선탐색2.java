package boj.level25_그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_24480_알고리즘수업_깊이우선탐색2 {

    private static List<Integer>[] adList;
    private static boolean[] visited;
    private static int[] order;
    private static int cnt;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점의 수
        int M = Integer.parseInt(st.nextToken()); // 간선의 수
        int R = Integer.parseInt(st.nextToken()); // 시작 정점

        visited = new boolean[N + 1];
        order = new int[N];
        adList = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            adList[i] = new ArrayList();
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            adList[start].add(end);
            adList[end].add(start);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(adList[i], (o1, o2) -> o2 - o1);
        }

        dfs(R);

        Arrays.stream(order).forEach(System.out::println);
    }

    private static void dfs(int R) {
        if (visited[R]) {
            return;
        }
        visited[R] = true;
        order[R - 1] = ++cnt;

        for (int ad : adList[R]) {
            if (!visited[ad]) {
                dfs(ad);
            }
        }
    }
}
