package boj.level22_우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_01655_가운데를말해요 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            pq.offer(Integer.parseInt(st.nextToken()));
            System.out.println(pq);
//            Object[] pqArr = pq.toArray();
//            int[] arr = new int[pqArr.length];
//            for (int i = 0; i < pqArr.length; i++) {
//                arr[i] = (int) pqArr[i];
//            }
//            System.out.println(Arrays.toString(arr));
//            int arrLength = arr.length;
//
//            if (arrLength == 0) {
//                sb.append(arr[0]).append(System.lineSeparator());
//                continue;
//            }
//
//            if (arrLength % 2 == 1) {
//                sb.append(arr[arrLength / 2]).append(System.lineSeparator());
//            } else {
//                if (arr[arrLength / 2] > arr[arrLength / 2 - 1]) {
//                    sb.append(arr[arrLength / 2 - 1]).append(System.lineSeparator());
//                } else {
//                    sb.append(arr[arrLength / 2]).append(System.lineSeparator());
//                }
//            }
        }
        System.out.print(sb);
    }
}
