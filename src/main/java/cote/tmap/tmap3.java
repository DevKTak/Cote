package cote.tmap;

import java.util.LinkedList;
import java.util.Queue;

public class tmap3 {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{-10, 20, 30}, {-10, 0, 10}, {-20, 40, 1}}));
    }

    static class Pair {

        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int solution(int[][] board) {

        int[] dx = {1, 0};
        int[] dy = {0, 1};
        int[][] sumArr = new int[board.length][board.length];

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, 0));
        sumArr[0][0] = board[0][0];

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            for (int i = 0; i < 2; i++) {
                int xSum = pair.x + dx[i];
                int ySum = pair.y + dy[i];

                if (xSum < board.length && ySum < board.length) { // board 범위 안
                    int curValue = board[pair.x][pair.y];
                    int nextValue = board[xSum][ySum];
                    int nextSumValue = sumArr[xSum][ySum];

                    if (nextValue == 0) {
                        if (curValue < 0) {
                            sumArr[xSum][ySum] = -curValue;
                        }
                    } else {
                        if (Math.abs(curValue + nextValue) > Math.abs(nextSumValue)) {
                            sumArr[xSum][ySum] = curValue + nextValue;
                        }
                    }
                    queue.offer(new Pair(xSum, ySum));
                }
            }
        }

        return board[board.length - 1][board.length - 1];

    }
}
