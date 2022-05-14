package boj.level25_그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 바이러스
 */
public class boj_02606_바이러스 {

    private static List<Integer>[] adList; // 인접리스트
    private static boolean checkArr[]; // 방문여부
    private static int cnt = -1; // 바이러스에 감염된 컴퓨터 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int computerCnt = Integer.parseInt(br.readLine());
        int computerPairCnt = Integer.parseInt(br.readLine());
        adList = new ArrayList[computerCnt + 1];
        checkArr = new boolean[computerCnt + 1];

        for (int i = 1; i <= computerCnt; i++) {
            adList[i] = new ArrayList<>();
        }

        for (int i = 0; i < computerPairCnt; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            adList[start].add(end);
            adList[end].add(start);
        }

//        dfs(1); // dfs로 풀기
        bfs(1); // bfs로 풀기
        System.out.println(cnt);
    }

    private static void dfs(int curComputer) {
        if (checkArr[curComputer]) { // 방문한 적이 있다면
            return;
        }
        cnt++;
        checkArr[curComputer] = true;

        for (int ad : adList[curComputer]) {
            if (!checkArr[ad]) {
                dfs(ad);
            }
        }
    }

    private static void bfs(int curComputer) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(curComputer);
        checkArr[curComputer] = true;

        while (!queue.isEmpty()) {
            cnt++;

            for (int ad : adList[queue.poll()]) {
                if (!checkArr[ad]) {
                    checkArr[ad] = true;
                    queue.offer(ad);
                }
            }
        }
    }
}
