package class1;

import java.util.Scanner;

public class bj_09498 {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();

        if (N >= 90) {
            System.out.println("A");
        } else if (N >= 80) {
            System.out.println("B");
        } else if (N >= 70) {
            System.out.println("C");
        } else if (N >= 60) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
    }
}
