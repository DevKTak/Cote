package class1;

import java.util.Scanner;

public class bj_02675 {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt(); // 테스트 케이스 수

        for (int i = 0; i < T; i++) {
            int R = scanner.nextInt(); // 반복 횟수
            String S = scanner.next(); // 반복할 문자열

            for (int j = 0; j < S.length(); j++) {
                for (int k = 0; k < R; k++) {
                    System.out.print(S.charAt(j));
                }
            }

            System.out.println();
        }

    }
}
