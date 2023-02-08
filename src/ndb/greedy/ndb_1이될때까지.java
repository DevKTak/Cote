package ndb.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ndb_1이될때까지 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        /*
            n의 크기가 큰 경우를 생각 안한 풀이

        int cnt = 0;

        while (n != 1) {
            if (n % k == 0) {
                n /= k;
            } else {
                n -= 1;
            }
            cnt++;
        }
        System.out.println(cnt);
        */

        /**
         * n = 16, k = 5
         *
         * (16 - 1) / 5 - 1 - 1
         */

        int result = 0;

        while (true) {
            // N이 K로 나누어 떨어지 않는다고 했을때 가장 가까운 k로 나누어 떨어지는 수를 찾는다.
            int target = (n / k) * k; // 테크닉 사용
            result += (n - target); // -1을 해야하는 횟수
//            n = target; // n이 타겟이 될 수 있도록 변경

            // K로 나누기
            result += 1;
            n /= k;

            // N이 K보다 작을 때 (더 이상 나눌 수 없을 때) 반복문 탈출
            if (n < k) {
                break;
            }
        }

        // 마지막으로 남은 수에 대하여 1이 될 때까지 1씩 빼기
        result += (n - 1);
        System.out.println(result);
    }
}
