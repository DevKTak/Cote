

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static List<Integer>[] adList;
    private static boolean[] visited;
    private static int sequence = 0;
    private static int[] sequenceArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        adList = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        sequenceArr = new int[N];

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

        for (int i = 1; i <= N ; i++) {
            Collections.sort(adList[i]);
        }

        dfs(R);
        Arrays.stream(sequenceArr).forEach(System.out::println);
    }

    private static void dfs(int R) {
        if (visited[R]) {
            return;
        }
        visited[R] = true;
        sequenceArr[R - 1] = ++sequence;

        for (int ad : adList[R]) {
            if (!visited[ad]) {
                dfs(ad);
            }
        }
    }
}
