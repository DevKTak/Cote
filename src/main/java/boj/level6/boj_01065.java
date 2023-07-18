package boj.level6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 한수 */
public class boj_01065 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        if (N < 100) {
            System.out.println(N);
        } else {
            int cnt = 99;

            for (int i = 100; i <= N; i++) {
                if (isHansu(i) && (i != 1000)) {
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }

    private static boolean isHansu(int i) {
        int[] arr = new int[3];

        for (int j = 0; j < 3; j++) {
            arr[j] = i % 10;
            i = i / 10;
        }

        if (arr[2] - arr[1] == arr[1] - arr[0]) {
            return true;
        } else {
            return false;
        }
    }
}
