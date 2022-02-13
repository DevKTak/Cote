package boj.level7;

import java.util.Scanner;

/** 크로아티아 알파벳 */
public class boj_02941 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        solution1(str);

        solution2(str);

    }

    private static void solution2(String str) {
        String[] strArr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for (String s : strArr) {
            if (str.contains(s)) {
                str = str.replace(s, "@");
            }
        }
        System.out.println(str.length());
    }

    private static void solution1(String str) {
        char[] charArr = str.toCharArray();
        int cnt = 0;

        for (int i = 0; i < charArr.length; i++) {
            if (i < charArr.length - 1) {
                String s = "" + charArr[i] + charArr[i + 1];

                if (s.equals("c=") || s.equals("c-") || s.equals("d-") || s.equals("lj") || s.equals("nj") || s.equals("s=") || s.equals("z=")) {
                    i += 1;
                }
            }

            if (i < charArr.length - 2) {
                String s = "" + charArr[i] + charArr[i + 1] + charArr[i + 2];

                if (s.equals("dz=")) {
                    i += 2;
                }
            }
            cnt++;
        }

        System.out.println(cnt);
    }
}
