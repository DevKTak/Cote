class Solution {
    public String solution(String s) {
		String[] arr = s.toLowerCase().split("");
		arr[0] = arr[0].toUpperCase();

		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1].equals(" ") && !arr[i].equals(" ")) {
				arr[i] = arr[i].toUpperCase();
			}
		}
		return String.join("", arr);
    }
}