package class2;

import java.util.Scanner;

public class bj_15829 {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int L = scanner.nextInt(); // 문자열 길이
        int M = 1234567891;
        char arr[] = scanner.next().toCharArray();
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += (arr[i] - 96) * Math.pow(31, i) % M;
        }

        System.out.println(sum % M);
    }
}
