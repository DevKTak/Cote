package class1;

import java.util.Scanner;

public class bj_02475 {

    public static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int N = 0;
        int sum = 0;

        for (int i = 0; i < 5; i++) {
            N = sc.nextInt();
            sum += Math.pow(N, 2);
        }

        System.out.println(sum % 10);
    }
}
