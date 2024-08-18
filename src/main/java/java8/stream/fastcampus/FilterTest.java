package java8.stream.fastcampus;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *	패스트 캠퍼스 강의
 */
public class FilterTest {

	public static void main(String[] args) {

		// Filter 익명함수
		Stream<Integer> numberStream = Stream.of(3, -5, 7, 10, -3);
		Stream<Integer> filteredNumberStream = numberStream.filter(new Predicate<Integer>() {
			@Override
			public boolean test(Integer x) {
				return x > 0;
			}
		});
		List<Integer> filteredNumbers = filteredNumberStream.collect(Collectors.toList());
		System.out.println(filteredNumbers);

		// Filter 람다식
		List<Integer> collect = Stream.of(3, -5, 7, 10, -3)
			.filter(x -> x > 0).toList();
		System.out.println(collect);

	}
}
