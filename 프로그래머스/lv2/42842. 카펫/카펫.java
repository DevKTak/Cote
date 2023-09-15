import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(int brown, int yellow) {
    int[] answer = new int[2];
        int total = brown + yellow; // 전체 격자 수
        
        // 가능한 가로 길이와 세로 길이의 조합을 찾기 위한 반복문
        for (int x = 1; x <= total; x++) {
            if (total % x == 0) {
                int y = total / x;
                if ((x + y) * 2 == brown + 4) { // 주어진 갈색 격자 수와 맞는지 확인
                    answer[0] = y;
                    answer[1] = x;
                    break;
                }
            }
        }
        
        return answer;
    }
}