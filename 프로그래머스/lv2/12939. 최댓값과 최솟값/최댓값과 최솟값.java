import java.util.*;

class Solution {
    public String solution(String s) {
		String[] arr = s.split(" ");
		Arrays.sort(arr, Comparator.comparingInt(Integer::parseInt));

		return arr[0] + " " + arr[arr.length - 1];
    }
}