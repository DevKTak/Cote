package boj.level12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 수 정렬하기
 * Arrays.sort(Array)
 * dual-pivot Quick Sort 알고리즘 사용
 * 평균: O(nlogn), 최악: O(n²)
 */
public class boj_02750 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        for (int val : arr) {
            sb.append(val + "\n");
        }
        System.out.println(sb);
    }
}
