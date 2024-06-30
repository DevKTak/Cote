package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class K번째수 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution()));
	}

	public static int[] solution() {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

		int[] result = new int[commands.length];

		for (int j = 0; j < commands.length; j++) {
			List<Integer> list = new ArrayList<>();

			for (int i = commands[j][0] - 1; i < commands[j][1]; i++) {
				list.add(array[i]);
			}
			list.sort(null);
			result[j] = (list.get(commands[j][2] - 1));
		}

		return result;
	}
}
