package class1;

import java.util.Scanner;

public class bj_10952 {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            if (a == 0 && b == 0) {
                break;
            } else {
                System.out.println(a + b);
            }
        }
    }
}
