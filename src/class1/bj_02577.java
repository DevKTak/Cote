package class1;

import java.util.Scanner;

public class bj_02577 {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        long result = A * B * C;
        String resultStr = String.valueOf(result);
        String resultStrArr[] = resultStr.split("");
        int countArr[] = new int[10];

        for (int i = 0; i < resultStr.length(); i++) {
            countArr[Integer.parseInt(resultStrArr[i])]++;
        }

        for (int temp : countArr) {
            System.out.println(temp);
        }
    }
}
