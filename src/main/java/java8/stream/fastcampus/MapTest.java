package java8.stream.fastcampus;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapTest {

	public static void main(String[] args) {

		// Map 익명함수
		List<Integer> numberList = Arrays.asList(3, 6, -4);
		Stream<Integer> numberStream = numberList.stream();
		Stream<Integer> numberStreamX2 = numberStream.map(new Function<Integer, Integer>() {
			@Override
			public Integer apply(Integer x) {
				return x * 2;
			}
		});
		List<Integer> numberListX2 = numberStreamX2.collect(Collectors.toList());
		System.out.println("numberListX2 = " + numberListX2);

		// Map 람다식
		List<Integer> collect = Stream.of(3, 6, -4)
			.map(x -> x * 2)
			.toList();
		System.out.println("collect = " + collect);
	}
}
