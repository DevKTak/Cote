package boj.etc;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 숫자 카드 2
 */
public class boj_10816_숫자카드2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

      /*
        [Map 이용]
        Map<Integer, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int key = Integer.parseInt(st.nextToken());
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            bw.write(map.getOrDefault(Integer.parseInt(st.nextToken()), 0) + " ");
        }
        bw.flush();
        bw.close();
       */

        // [카운팅 소트]
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[20000001]; // -10,000,000 ~ 10,000,000

        for (int i = 0; i < N; i++) {
            arr[Integer.parseInt(st.nextToken()) + 10000000]++;
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            bw.write(arr[Integer.parseInt(st.nextToken()) + 10000000] + " ");
        }
        bw.flush();
        bw.close();
    }
}
