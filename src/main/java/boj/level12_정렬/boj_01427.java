package boj.level12_정렬;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 소트인사이드
 */
public class boj_01427 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] sArr = s.split("");

        // 방법 1
        desc(sArr);

        // 방법 2 Counting Sort(카운팅 정렬)
        countingSort(Integer.parseInt(s));

    }

    private static void desc(String[] sArr) {
        Arrays.sort(sArr, Comparator.reverseOrder());

        for (String str : sArr) {
            System.out.print(str);
        }
    }

    private static void countingSort(int num) {
        int[] countingArr = new int[10]; // 0 ~ 9 까지 10칸만 필요

        while (num != 0) {
            countingArr[num % 10]++; // 끝에 한자리씩 카운팅 배열 인덱스에 카운트 올려줌
            num /= 10;
        }

        for (int i = 9; i >= 0 ; i--) { // 내림차순이므로 반대로
            while (countingArr[i]-- > 0) { // 배열값에 있는 카운트 만큼 찍기
                System.out.print(i);
            }
        }
    }
}
