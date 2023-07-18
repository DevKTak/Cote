package ndb.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class ndb_큰수의법칙 {

    public static void main(String[] args) throws IOException {
        /**
            5 8 2
            2 4 5 4 6
            => 46
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 배열의 크기
        int M = Integer.parseInt(st.nextToken()); // 숫자가 더해지는 횟수
        int K = Integer.parseInt(st.nextToken()); // 한 숫자가 더할수 있는 횟수
        Integer[] arr = new Integer[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
//        Arrays.sort(arr, (o1, o2) -> o2 - o1);
        Arrays.sort(arr, Collections.reverseOrder());

         /*
            내가 푼 풀이

            int cnt = 0;
            int index = 0;
            int[] top2arr = {arr[0], arr[1]};
            int result = 0;

           for (int i = 0; i < M; i++) {
                cnt++;

                if (cnt == K) {
                    cnt = 0;
                    index = 1;
                }
                result += top2arr[index];
                index = 0;
            }
            System.out.println(result);
        */

        // ============================================================== //

        // 가장 큰 수가 더해지는 횟수 구하기
        int cnt = (M / (K + 1)) * K;

        // M이 (K + 1)로 나누어 떨어지지 않는 경우도 고려해야한다. 나눈 나머지만큼 가장 큰 수가 추가로 더해진다.
        cnt += M % (K + 1);

        int result = 0;
        result += cnt * arr[0]; // 가장 큰 수 더하기
        result += (M - cnt) * arr[1]; // 두 번째로 큰 수 더하기

        System.out.println(result);
    }
}
