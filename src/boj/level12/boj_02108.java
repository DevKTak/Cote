package boj.level12;

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

            for (int num : list) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            int maxCnt = Integer.MIN_VALUE; // 최빈값의 갯수

            for (int cnt : map.values()) {
                maxCnt = Math.max(cnt, maxCnt);
            }

            list.clear();

            for (int num : map.keySet()) {
                if (map.get(num) == maxCnt) {
                    list.add(num);
                }
            }

            if (list.size() >= 2) {
                Collections.sort(list);
                return list.get(1);
            } else {
                return list.get(0);
            }
        }
    }
}
