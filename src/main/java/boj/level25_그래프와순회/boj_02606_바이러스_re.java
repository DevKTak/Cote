package boj.level25_그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 바이러스
 */
public class boj_02606_바이러스_re {

    private static List<Integer>[] adList; // 인접리스트
    private static boolean visited[]; // 방문여부
    private static int cnt = 0; // 바이러스에 감염된 컴퓨터 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int computerCnt = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        int computerPairCnt = Integer.parseInt(br.readLine()); // 컴퓨터 쌍의 수

        adList = new ArrayList[computerCnt + 1]; // 배열 초기화
        visited = new boolean[computerCnt + 1];

        for (int i = 1; i <= computerCnt ; i++) {
            adList[i] = new ArrayList<>(); // 리스트 초기화
        }

        while (computerPairCnt-- > 0) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adList[start].add(end);
            adList[end].add(start);
        }
        bfs(1);
        System.out.println(cnt);
    }



    private static void bfs(int curComputer) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(curComputer);
        visited[curComputer] = true;

        while (!q.isEmpty()) {

            for (int ad : adList[q.poll()]) {
                if (!visited[ad]) {
                    cnt++;
                    visited[ad] = true;
                    q.offer(ad);
                }
            }
        }
    }
}
