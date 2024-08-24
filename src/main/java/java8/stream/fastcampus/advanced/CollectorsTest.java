package java8.stream.fastcampus.advanced;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// map, 이나 reduce 등으로 대체 가능하지만
// GroupingBy 에서 쓰여서 알아둬야할 것 같음
public class CollectorsTest {

	public static void main(String[] args) {
		List<Integer> numberList = Stream.of(3, 5, -3, 3, 4, 5).toList();
		System.out.println(numberList);

		Set<Integer> numberSet = Stream.of(3, 5, -3, 3, 4, 5)
			.collect(Collectors.toSet());
		System.out.println(numberSet);

		List<Integer> numberList2 = Stream.of(3, 5, -3, 3, 4, 5)
			.collect(Collectors.mapping(x -> Math.abs(x), Collectors.toList()));
		System.out.println(numberList2);

		Set<Integer> numberSet2 = Stream.of(3, 5, -3, 3, 4, 5)
			// .collect(Collectors.mapping(x -> Math.abs(x), Collectors.toSet()));
			.map(x -> Math.abs(x)).collect(Collectors.toSet());
		System.out.println(numberSet2);

		int sum = Stream.of(3, 5, -3, 3, 4, 5).reduce(0, (x, y) -> x + y);
		System.out.println(sum);
	}
}
