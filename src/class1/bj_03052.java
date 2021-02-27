package class1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class bj_03052 {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int arr[] = new int[42];

        for (int i = 0; i < 10; i++) {
            int n = scanner.nextInt();
            arr[n % 42]++;
        }

        int cnt = 0;

        for (int temp : arr) {
            if (temp != 0) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
