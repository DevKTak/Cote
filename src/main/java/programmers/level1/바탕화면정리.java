package programmers.level1;

import java.util.Arrays;

public class 바탕화면정리 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] {".#...", "..#..", "...#."})));
	}

	private static int[] solution(String[] wallpaper) {
		int minRow = Integer.MAX_VALUE, minCol = Integer.MAX_VALUE;
		int maxRow = Integer.MIN_VALUE, maxCol = Integer.MIN_VALUE;

		for (int i = 0; i < wallpaper.length; i++) {
			for (int j = 0; j < wallpaper[i].length(); j++) {
				if (wallpaper[i].charAt(j) == '#') {
					minRow = Math.min(i, minRow);
					minCol = Math.min(j, minCol);
					maxRow = Math.max(i, maxRow);
					maxCol = Math.max(j, maxCol);
				}
			}
		}
		return new int[] {minRow, minCol, maxRow + 1, maxCol + 1};
	}
}
