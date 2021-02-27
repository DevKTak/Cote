package class1;

import java.util.Scanner;

public class bj_10809 {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        char arr[] = scanner.next().toCharArray();

        for (int i = 97; i < 123; i++) {
            int flag = 0;

            for (int j = 0; j < arr.length; j++) {
                if ((int) arr[j] == i) {
                    System.out.print(j + " ");
                    flag = 1;
                    break;
                }
            }

            if (flag == 0) {
                System.out.print("-1 ");
            }
        }
    }
}
