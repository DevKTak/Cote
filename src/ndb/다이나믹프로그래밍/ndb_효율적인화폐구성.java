package ndb.다이나믹프로그래밍;

import java.util.Arrays;

public class ndb_효율적인화폐구성 {

    public static void main(String[] args) {
        int n = 3; // N가지 종류의 화폐
        int m = 7; // 목표 금액
        int[] arr = {2, 3, 5};
        int[] d = new int[m + 1]; // 금액 1 ~ 15까지 최소 금액 조합의 카운트로 갱신하는 dp 테이블
        Arrays.fill(d, 10001);
        d[0] = 0;

        for (int i = 0; i < n; i++) { // 화폐 종류별로 검사
            for (int j = arr[i]; j <= m; j++) { // 화폐 금액부터 목표 금액까지 테이블 갱신
                d[j] = Math.min(d[j], d[j - arr[i]] + 1);
            }
        }

        if (d[m] == 10001) {
            System.out.println(-1);

            return;
        }
        System.out.println(d[m]);
    }
}
