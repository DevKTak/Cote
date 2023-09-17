import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
	Arrays.sort(people);

		int leftIndex = 0;
		int rightIndex = people.length - 1;
		int cnt = 0;

		while (leftIndex <= rightIndex) {
			if (people[leftIndex] + people[rightIndex] <= limit) {
				leftIndex++;
				rightIndex--;
				cnt++;
			} else {
				rightIndex--;
				cnt++;
			}
		}
		return cnt;
    }
}