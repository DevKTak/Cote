package class1;

import java.util.Scanner;

public class bj_02908 {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String a = scanner.next();
        String b = scanner.next();
        StringBuilder sb = new StringBuilder(a);
        StringBuilder sb2 = new StringBuilder(b);
        a = sb.reverse().toString();
        b= sb2.reverse().toString();

        System.out.println(Math.max(Integer.parseInt(a), Integer.parseInt(b)));
    }
}
