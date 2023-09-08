import java.util.*;

class Solution {
    public String solution(String s) {
// 		String[] arr = s.split(" ");
// 		Arrays.sort(arr, Comparator.comparingInt(Integer::parseInt));

// 		return arr[0] + " " + arr[arr.length - 1];
        
           // 문자열을 공백으로 나누어 숫자 배열로 변환
        String[] numbers = s.split(" ");
        
        // 초기 최소값과 최대값 설정
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        // 숫자 배열을 순회하며 최소값과 최대값 업데이트
        for (String numStr : numbers) {
            int num = Integer.parseInt(numStr);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        // 결과 문자열 생성 후 반환
        return min + " " + max;
    }
}