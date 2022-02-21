package boj.level12_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 통계학
 */
public class boj_02108 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        int i = N;

        while (i-- > 0) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);

        System.out.println(Statistics.getArithmeticalAverage(list, N));
        System.out.println(Statistics.getMedianValue(list, N));
        System.out.println(Statistics.getMode(list));
        System.out.println(Statistics.getRange(list));
    }

    static class Statistics {

        /** 산술평균 */
        public static int getArithmeticalAverage(List<Integer> list, int N) {
            int sum = 0;

            for (int val : list) {
                sum += val;
            }
            return (int) Math.round((double) sum / N);
        }

        /** 중앙값 */
        public static int getMedianValue(List<Integer> list, int N) {
            return list.get(N / 2);
        }

        /** 최빈값 */
        public static int getMode(List<Integer> list) {
            Map<Integer, Integer> map = new HashMap<>();
            List<Integer> maxList = new ArrayList<>(); // 최빈값인 값들의 리스트

            for (int num : list) {
                // key: 리스트의 값, value: 빈도수
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            int maxCnt = Integer.MIN_VALUE; // 최빈값의 갯수

            for (int cnt : map.values()) {
                maxCnt = Math.max(cnt, maxCnt);
            }

            for (int num : map.keySet()) {
                if (map.get(num) == maxCnt) {
                    maxList.add(num);
                }
            }

            if (maxList.size() >= 2) { // 최빈값이 여러개 있을 경우
                Collections.sort(maxList); // 두 번째 작은 값을 위한 정렬
                return maxList.get(1);
            } else {
                return maxList.get(0);
            }
        }

        /** 범위 */
        public static int getRange(List<Integer> list) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < list.size(); i++) {
                max = Math.max(list.get(i), max);
                min = Math.min(list.get(i), min);
            }

            return max - min;
        }
    }
}
