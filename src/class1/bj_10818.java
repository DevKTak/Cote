package class1;

import java.util.Arrays;
import java.util.Scanner;

public class bj_10818 {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        int arr[] = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);

        System.out.println(arr[0] + " " + arr[N-1]);
    }
}
