package cote.tmap;

import java.util.Arrays;

public class tmap6 {

    public static void main(String[] args) {
        int[][] solution = solution(3, new int[][]{{1, 2}, {3, 3}});

        for (int[] v : solution) {
            System.out.println(Arrays.toString(v));
        }
    }

    private static int[][] solution(int N, int[][] bus_stop) {
        int[][] distance = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int minValue = Integer.MAX_VALUE;

                for (int k = 0; k < bus_stop.length; k++) {
                    int sum = Math.abs(i - (bus_stop[k][0] - 1)) + Math.abs(j - (bus_stop[k][1] - 1));
                    distance[i][j] = minValue = Math.min(minValue, sum);
                }
            }
        }

        return distance;
    }
}
