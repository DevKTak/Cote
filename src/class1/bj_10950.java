package class1;

import java.util.Scanner;

public class bj_10950 {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            System.out.println(scanner.nextInt() + scanner.nextInt());
        }
    }
}
