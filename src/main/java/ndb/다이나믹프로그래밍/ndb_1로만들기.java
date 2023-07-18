package ndb.다이나믹프로그래밍;

import java.util.Scanner;

public class ndb_1로만들기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int[] cntMemo = new int[30001];

        // cntMemo[1] = 0
        for (int i = 2; i <= x; i++) {
            // i -1, i / 5, i / 3, i / 2 중 뭐가 제일 나누는 횟수가 적은지 비교비교비교

            cntMemo[i] = cntMemo[i - 1] + 1;

            if (i % 5 == 0) {
                cntMemo[i] = Math.min(cntMemo[i], cntMemo[i / 5] + 1);
            }

            if  (i % 3 == 0) {
                cntMemo[i] = Math.min(cntMemo[i], cntMemo[i / 3] + 1);
            }

            if (i % 2 == 0) {
                cntMemo[i] = Math.min(cntMemo[i], cntMemo[i / 2] + 1);
            }
        }
        System.out.println(cntMemo[x]);
    }
}
