package ndb.그리디;

import java.util.Arrays;

public class ndb_모험가길드 {

    public static void main(String[] args) {
        int n = 5;
//        Integer[] arr = {2, 3, 1, 2, 2};
        Integer[] arr = {3, 2, 4, 4, 4};
//        Integer[] arr = {6, 2, 1, 3, 2};

        /* 나의풀이
        Arrays.sort(arr, Comparator.reverseOrder());
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            i += arr[i] - 1;
            if (i < arr.length) {
                cnt++;
            }
        }
        System.out.println(cnt);
         */

       /* int cnt = 0; // 현재 그룹에 포함된 모험가의 수
        int result = 0; // 총 그룹의 수

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) { // 공포도가 낮은 것부터
            cnt++; // 현재 그룹에 모험가 포함

            if (cnt >= arr[i]) { // 그룹에 포함된 모험가의 수가 현재의 공포도 이상이라면, 그룹 결성
                result++; // 그룹 수 추가
                cnt = 0; // 현재 그룹에 포함된 모함가의 수 초기화
            }
        }
        System.out.println(result);*/

        int curCnt = 0;
        int teamCnt = 0;

        Arrays.sort(arr);

        for (int v : arr) {
            curCnt++;

            if (v == curCnt) {
                teamCnt++;
                curCnt = 0;
            }
        }
        System.out.println(teamCnt);










    }
}
