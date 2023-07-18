package boj.level7;

import java.util.Scanner;

/** 다이얼 */
public class boj_05622 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toUpperCase();
        sc.close();

        char[] charArr = str.toCharArray();

        getDialTime(charArr);
    }

    public static void getDialTime(char[] charArr) {
        int time = 0;

        for (int i = 0; i < charArr.length; i++) {
            if (65 <= charArr[i] && charArr[i] < 68) { // ABC
                time += 3;
            } else if (68 <= charArr[i] && charArr[i] < 71) { // DEF
                time += 4;
            } else if (71 <= charArr[i] && charArr[i] < 74) { // GHI
                time += 5;
            } else if (74 <= charArr[i] && charArr[i] < 77) { // JKL
                time += 6;
            } else if (77 <= charArr[i] && charArr[i] < 80) { // MNO
                time += 7;
            } else if (80 <= charArr[i] && charArr[i] < 84) { // PQRS
                time += 8;
            } else if (84 <= charArr[i] && charArr[i] < 87) { // TUV
                time += 9;
            } else {
                time += 10;
            }
        }

        System.out.println(time);
    }
}
