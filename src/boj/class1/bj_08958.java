package boj.class1;

import java.util.Scanner;

public class bj_08958 {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();
        int sum = 0;

        for (int i = 0; i < T; i++) {
            String str = scanner.next();
            char charArr[] = str.toCharArray();
            int cnt = 0;
            sum = 0;

            for (int j = 0; j < charArr.length; j++) {
                if (charArr[j] == 'O' && j == charArr.length - 1) {
                    cnt++;
                    sum += cnt * (cnt + 1) / 2;
                } else if (charArr[j] == 'X') {
                    sum += cnt * (cnt + 1) / 2;
                    cnt = 0;
                } else if (charArr[j] == 'O' ) {
                    cnt++;
                }
            }

            System.out.println(sum);
        }
    }
}
