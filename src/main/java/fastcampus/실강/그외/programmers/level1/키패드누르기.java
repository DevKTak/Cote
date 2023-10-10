package fastcampus.실강.그외.programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class 키패드누르기 {

	public static void main(String[] args) {
		키패드누르기 P = new 키패드누르기();
		System.out.println(P.solution(new int[] {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
	}

	public String solution(int[] numbers, String hand) {
		Map<Integer, FingerPlace> numberPlaceMap = new HashMap<>();
		numberPlaceMap.put(1, new FingerPlace(0, 0));
		numberPlaceMap.put(2, new FingerPlace(0, 1));
		numberPlaceMap.put(3, new FingerPlace(0, 2));
		numberPlaceMap.put(4, new FingerPlace(1, 0));
		numberPlaceMap.put(5, new FingerPlace(1, 1));
		numberPlaceMap.put(6, new FingerPlace(1, 2));
		numberPlaceMap.put(7, new FingerPlace(2, 0));
		numberPlaceMap.put(8, new FingerPlace(2, 1));
		numberPlaceMap.put(9, new FingerPlace(2, 2));
		numberPlaceMap.put(0, new FingerPlace(3, 1));

		FingerPlace curLeftPlace = new FingerPlace(3, 0);
		FingerPlace curRightPlace = new FingerPlace(3, 2);

		StringBuilder sb = new StringBuilder();

		for (int goalNumber : numbers) {
			switch (goalNumber) {
				case 1, 4, 7 -> {
					sb.append("L");
					curLeftPlace = numberPlaceMap.get(goalNumber);
				}
				case 3, 6, 9 -> {
					sb.append("R");
					curRightPlace = numberPlaceMap.get(goalNumber);
				}
				case 2, 5, 8, 0 -> {
					int leftDistance = calFingerDistance(curLeftPlace, goalNumber, numberPlaceMap);
					int rightDistance = calFingerDistance(curRightPlace, goalNumber, numberPlaceMap);

					if (leftDistance > rightDistance) {
						sb.append("R");
						curRightPlace = numberPlaceMap.get(goalNumber);
					} else if (leftDistance == rightDistance) {
						if (hand.equals("right")) {
							sb.append("R");
							curRightPlace = numberPlaceMap.get(goalNumber);
						} else {
							sb.append("L");
							curLeftPlace = numberPlaceMap.get(goalNumber);
						}
					} else {
						sb.append("L");
						curLeftPlace = numberPlaceMap.get(goalNumber);
					}
				}
				default -> throw new IllegalArgumentException("오타");
			}
		}
		return sb.toString();
	}

	private int calFingerDistance(FingerPlace curFingerPlace, int goalNumber, Map<Integer, FingerPlace> numberPlace) {
		return Math.abs(curFingerPlace.getRow() - numberPlace.get(goalNumber).getRow())
			+ Math.abs(curFingerPlace.getCol() - numberPlace.get(goalNumber).getCol());
	}

	private class FingerPlace {

		int row;
		int col;

		private FingerPlace(int row, int col) {
			this.row = row;
			this.col = col;
		}

		public int getRow() {
			return row;
		}

		public int getCol() {
			return col;
		}
	}
}
