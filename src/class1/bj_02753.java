package class1;

import java.util.Scanner;

public class bj_02753 {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();

        if ((N % 4 == 0 && N % 100 != 0) || N % 400 == 0) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}
