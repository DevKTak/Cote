package goorm.No4;

import java.util.Scanner;

public class H {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int M = scanner.nextInt();
            int N = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            kaingCalendar(M, N, x, y);
        }


    }

    private static void kaingCalendar(int M, int N, int x, int y) {
        boolean flag = false;

        for (int i = x; i <= M * N; i += M) {
            if ((i - 1) % N + 1 == y) {
                System.out.println(i);
                flag = true;
                break;
            }
        }

        if (!flag) {
            System.out.println(-1);
        }
    }
}
