package class1;

import java.util.Scanner;

public class bj_11720 {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        char arr[] = scanner.next().toCharArray();
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] - '0';
        }

        System.out.println(sum);
    }
}
