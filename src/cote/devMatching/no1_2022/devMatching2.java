package cote.devMatching.no1_2022;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class devMatching2 {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"??b", "abc", "cc?"}));
        System.out.println(solution(new String[]{"abcabcab", "????????"}));
    }

    static class Pair {

        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int[][] arr;
    private static int[][] check;

    private static int solution(String[] grid) {
        arr = new int[grid.length][grid[0].length()];
        check = new int[grid.length][grid[0].length()];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (grid[i].substring(j, j + 1).equals("a")) {
                    arr[i][j] = 1;
                } else if (grid[i].substring(j, j + 1).equals("b")) {
                    arr[i][j] = 2;
                } else if (grid[i].substring(j, j + 1).equals("c")) {
                    arr[i][j] = 3;
                } else {
                    arr[i][j] = 4;
                }
            }
        }

        for (int[] s : arr) {
            System.out.println(Arrays.toString(s));
        }

        bfs(0, 0);

        return 1;

    }

    private static void bfs(int row, int col) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<Pair> queue = new LinkedList<>();

        if (arr[row][col] == 4) {
            for (int i = 0; i < 3; i++) {
                check[row][col] = i;
            }
        }
    }
}
