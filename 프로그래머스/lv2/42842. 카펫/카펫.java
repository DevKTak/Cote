import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(int brown, int yellow) {
 	int[] result = new int[2];
		int total = brown + yellow;

		for (int col = 1; col <= Math.sqrt(total); col++) {
			if (total % col == 0) {
				int row = total / col;

				if ((row - 2) * (col - 2) == yellow) {
					result[0] = row;
					result[1] = col;

					break;
				}
			}
		}
		return result;
    }
}