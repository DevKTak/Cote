package ndb.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ndb_시각 {

    public static boolean threeCheck(int h, int m, int s) {
        return h % 10 == 3 || m / 10 == 3 || m % 10 == 3 || s / 10 == 3 || s % 10 == 3;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int h = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 0; i < h + 1; i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    if (threeCheck(i, j, k)) {
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
