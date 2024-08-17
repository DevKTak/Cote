package java8.functionalInterface;

import java.util.function.Predicate;

public class PredicateTest {

	public static void main(String[] args) {
		// 아래 주석은 익명클래스
		// Predicate<Integer> isPositive = new Predicate<Integer>() {
		// 	@Override
		// 	public boolean test(Integer x) {
		// 		return x > 0;
		// 	}
		// };

		// 위의 익명 클래스를 간단하게 람다식으로 표현
		Predicate<Integer> isPositive = x -> x > 0;

		System.out.println(isPositive.test(10));

		Predicate<Integer> negate = isPositive.negate();
		System.out.println(negate.test(10));

		System.out.println(isPositive.or(x -> x == 0).test(10));

		Predicate<Integer> not = Predicate.not(isPositive);
		System.out.println(not.test(10));
	}
}
