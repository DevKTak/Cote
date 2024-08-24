package java8.stream.fastcampus.advanced;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import java8.stream.fastcampus.pojoModel.Order;
import java8.stream.fastcampus.pojoModel.Order.OrderStatus;
import java8.stream.fastcampus.pojoModel.User;

public class MaxMinCount {

	public static void main(String[] args) {
		Optional<Integer> max = Stream.of(5, 3, 6, 2, 1)
			.max(Comparator.naturalOrder());
		// .max(Integer::compareTo);
		System.out.println(max.get());

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

		// name 기준 오름차훈으로 가장 앞에 있는 유저 뽑아내기
		User firstUser = users.stream()
			.min(Comparator.comparing(User::getName))
			// .min((u1, u2) -> u1.getName().compareTo(u2.getName()))
			.get();
		System.out.println(firstUser);

		long positiveIntegerCount = Stream.of(1, -4, 5, -3, 6)
			.filter(x -> x > 0)
			.count();
		System.out.println("Positive integers: " + positiveIntegerCount);

		LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
		user1.setCreatedAt(now.minusDays(2));
		user2.setCreatedAt(now.minusHours(10));
		user3.setCreatedAt(now.minusHours(1));
		User user4 = new User()
			.setId(104)
			.setName("David")
			.setVerified(true)
			.setEmailAddress("david@fastcampus.co.kr")
			.setCreatedAt(now.minusHours(27));
		users = Arrays.asList(user1, user2, user3, user4);

		long unverifiedUsersIn24Hrs = users.stream()
			.filter(user -> user.getCreatedAt().isAfter(now.minusDays(1))) // 최근 1시간 이내
			.filter(user -> !user.isVerified()) // 인증되지 않은
			.count();
		System.out.println(unverifiedUsersIn24Hrs);

		Order order1 = new Order()
			.setId(1001L)
			.setAmount(BigDecimal.valueOf(2000))
			.setStatus(Order.OrderStatus.CREATED);
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

		// TODO: find order with highest amount an in ERROR status
		// 에러상태면서 금액이 가장 높은 주문
		Order erroredOrderWithMaxAmount = orders.stream()
			.filter(order -> order.getStatus() == OrderStatus.ERROR)
			// .max((o1, o2) -> o1.getAmount().compareTo(o2.getAmount()))
			.max(Comparator.comparing(Order::getAmount))
			.get();

		// 주문이 아니고 단순히 에러상태중에서 가장 큰 금액을 구하라면
		BigDecimal maxErroredAmount = orders.stream()
			.filter(order -> order.getStatus() == OrderStatus.ERROR)
			.map(order -> order.getAmount())
			// .max((o1, o2) -> o1.compareTo(o2))
			.max(BigDecimal::compareTo)
			.orElse(BigDecimal.ZERO);
	}
}
