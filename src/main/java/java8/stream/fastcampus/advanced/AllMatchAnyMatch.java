package java8.stream.fastcampus.advanced;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import java8.stream.fastcampus.pojoModel.Order;
import java8.stream.fastcampus.pojoModel.Order.OrderStatus;
import java8.stream.fastcampus.pojoModel.User;

public class AllMatchAnyMatch {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(3, -4, 2, 7, 9);
		boolean allPostive = numbers.stream()
			.allMatch(number -> number > 0);
		System.out.println("Are all numbers positive: " + allPostive);
		boolean anyNegative = numbers.stream()
			.anyMatch(number -> number < 0);
		System.out.println("Is any number negative: " + anyNegative);

		User user1 = new User()
			.setId(101)
			.setName("Alice")
			.setVerified(true)
			.setEmailAddress("alice@fastcampus.co.kr");
		User user2 = new User()
			.setId(102)
			.setName("Bob")
			.setVerified(false)
			.setEmailAddress("bob@fastcampus.co.kr");
		User user3 = new User()
			.setId(103)
			.setName("Charlie")
			.setVerified(false)
			.setEmailAddress("charlie@fastcampus.co.kr");
		List<User> users = Arrays.asList(user1, user2, user3);

		boolean areAllUserVerified = users.stream()
			// .allMatch(user -> user.isVerified());
			.allMatch(User::isVerified);
		System.out.println(areAllUserVerified);

		Order order1 = new Order()
			.setId(1001L)
			.setAmount(BigDecimal.valueOf(2000))
			.setStatus(OrderStatus.CREATED);
		Order order2 = new Order()
			.setId(1002L)
			.setAmount(BigDecimal.valueOf(4000))
			.setStatus(OrderStatus.ERROR);
		Order order3 = new Order()
			.setId(1003L)
			.setAmount(BigDecimal.valueOf(3000))
			.setStatus(OrderStatus.ERROR);
		Order order4 = new Order()
			.setId(1004L)
			.setAmount(BigDecimal.valueOf(7000))
			.setStatus(OrderStatus.PROCESSED);
		List<Order> orders = Arrays.asList(order1, order2, order3, order4);

		// TODO: check if any of orders is in ERROR status
		// 에러상태가 하나라도 있는지
		boolean isAnyOrderInErrorStatus = orders.stream().anyMatch(order -> order.getStatus() == OrderStatus.ERROR);
		System.out.println("isAnyOrderInErrorStatus = " + isAnyOrderInErrorStatus);
	}
}
