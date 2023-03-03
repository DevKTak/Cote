package boj.level25_그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * DFS와 BFS
 */
public class boj_01260_DFS와BFS {

    private static ArrayList<Integer>[] adList; // 인접 리스트(Adjacency-list)
    private static boolean[] checkArr; // 정점 방문 여부
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점의 개수
        int M = Integer.parseInt(st.nextToken()); // 간선의 개수
        int V = Integer.parseInt(st.nextToken()); // 정점의 번호
        adList = new ArrayList[N + 1]; // 정점의 개수 + 1 만큼 배열 생성 (0번 정점은 없기때문)

        for (int i = 1; i <= N; i++) { // 1 번방 부터 N 번방 까지 초기화 (0번방은 null로 두기)
            adList[i] = new ArrayList<>(); // 리스트 초기화
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            adList[start].add(end);
            adList[end].add(start);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(adList[i]);
        }

        /** 인접 리스트 출력 해보기
         *  adList는 ArrayList형인 배열임
         * */
        for (ArrayList list : adList) {
            System.out.println(list);
        }

        checkArr = new boolean[N + 1];
        dfs(V);

        Arrays.fill(checkArr, false);
        sb.append(System.lineSeparator());

        bfs(V);
        System.out.println(sb);

    }

    private static void dfs(int V) {
        if (checkArr[V]) {
            return;
        }
        checkArr[V] = true;
        sb.append(V).append(" ");

        for (int ad : adList[V]) {
            if (!checkArr[ad]) {
                dfs(ad);
            }
        }
    }

    private static void bfs(int V) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(V);
        checkArr[V] = true;

        while (!queue.isEmpty()) {
            int removeVal = queue.remove();
            sb.append(removeVal).append(" ");

            for (int ad : adList[removeVal]) {
                if (!checkArr[ad]) {
                    checkArr[ad] = true;
                    queue.offer(ad);
                }
            }
        }
    }
}
