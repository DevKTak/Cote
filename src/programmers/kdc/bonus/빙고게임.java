package programmers.kdc.bonus;

import java.util.Arrays;

public class 빙고게임 {

  public static void main(String[] args) {
//    System.out.println(solution(new int[][]{{11, 13, 15, 16}, {12, 1, 4, 3}, {10, 2, 7, 8}, {5, 14, 6, 9}}, new int[]{14, 3, 2, 4, 13, 1, 16, 11, 5, 15}));
    System.out.println(solution(new int[][]{{6,15,17,14,23}, {5,12,16,13,25}, {21,4,2,1,22}, {10,20,3,18,8}, {11,9,19,24,7}}, new int[]{15,7,2,25,9,16,12,18,5,4,10,13,20}));
  }

  private static int solution(int[][] board, int[] nums) {
    int answer = 0;
    Arrays.sort(nums);
    int length = board.length;

    for (int i = 0; i < length; i++) {
      for (int j = 0; j < length; j++) {
        if (Arrays.binarySearch(nums, board[i][j]) >= 0) {
          board[i][j] = 0;
        }
      }
    }

    for (int i = 0; i < length; i++) {
      System.out.println(Arrays.toString(board[i]));
    }

    /** 가로 **/
    for (int i = 0; i < length; i++) {
      int sum = 0;

      for (int j = 0; j < length; j++) {
        if (board[i][j] == 0) {
          sum++;
        }
      }

      if (sum == length) {
        answer++;
      }
    }

    /** 세로 **/
    for (int i = 0; i < length; i++) {
      int sum = 0;

      for (int j = 0; j < length; j++) {
        if (board[j][i] == 0) {
          sum++;
        }
      }

      if (sum == length) {
        answer++;
      }
    }

    /** 좌 => 우 대각선 **/
    int sum = 0;

    for (int i = 0; i < length; i++) {
      for (int j = 0; j < length; j++) {
        if (i == j && board[i][j] == 0) {
          sum++;
        }
      }
    }

    if (sum == length) {
      answer++;
    }

    /** 우 => 좌 대각선 **/
    sum = 0;
    int x = -1;
    int y = length;

    for (int i = 0; i < length; i++) {
      x++;
      y--;

      for (int j = 0; j < length; j++) {
        if (i == x && j == y && board[x][y] == 0) {
          sum++;
        }
      }
    }

    if (sum == length) {
      answer++;
    }

    return answer;
  }
}
