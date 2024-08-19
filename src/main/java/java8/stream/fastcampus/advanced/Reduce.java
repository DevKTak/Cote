package java8.stream.fastcampus.advanced;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import java8.stream.fastcampus.pojoModel.Order;
import java8.stream.fastcampus.pojoModel.OrderLine;
import java8.stream.fastcampus.pojoModel.User;

public class Reduce {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 4, -2, -5, 3);
		int sum = numbers.stream()
			// 메소드 레퍼런스로 간단하게 표현하는 방법
			// .reduce((x, y) -> x + y)
			.reduce(Integer::sum)
			.get();
		System.out.println(sum);

		int max = numbers.stream()
			// 메소드 레퍼런스로 간단하게 표현하는 방법
			// .reduce((x, y) -> x > y ? x : y)
			// .reduce((x, y) -> Math.max(x, y))
			.reduce(Math::max)
			.get();
		System.out.println(max);

		int product = numbers.stream()
			.reduce(1, (x, y) -> x * y);
		System.out.println(product);

		List<String> numberStrList = Arrays.asList("3", "2", "5", "-4");
		int sumOfNumberStrList = numberStrList.stream()
			.map(Integer::parseInt)
			.reduce(0, (x, y) -> x + y);
		System.out.println(sumOfNumberStrList);

		// mapToInt를 활용하여 int에 특화된 메서드 sum() 을 사용해서 푸는법
		int sumOfNumberStrList1_1 = numberStrList.stream()
			.mapToInt(Integer::parseInt).sum();
		System.out.println("sumOfNumberStrList1_1 = " + sumOfNumberStrList1_1);

		// 자주 쓰지 않는 방법 (이렇게도 쓴다정도)
		int sumOfNumberStrList2 = numberStrList.stream()
			.reduce(0, (number, str) -> number + Integer.parseInt(str), (num1, num2) -> num1 + num2);
		System.out.println(sumOfNumberStrList2);

		User user1 = new User()
			.setId(101)
			.setName("Alice")
			.setFriendUserIds(Arrays.asList(201, 202, 203, 204));
		User user2 = new User()
			.setId(102)
			.setName("Bob")
			.setFriendUserIds(Arrays.asList(204, 205, 206));
		User user3 = new User()
			.setId(103)
			.setName("Charlie")
			.setFriendUserIds(Arrays.asList(204, 205, 207));
		List<User> users = Arrays.asList(user1, user2, user3);


		int sumOfNumberOfFriends = users.stream()
			.map(User::getFriendUserIds)
			.map(List::size)
			.reduce(0, (x, y) -> x + y);

		// mapToInt을 활용하여 더하는 법
		// int sumOfNumberOfFriends = users.stream()
		// 	.map(User::getFriendUserIds)
		// 	.mapToInt(List::size)
		// 		.sum();
		System.out.println(sumOfNumberOfFriends);

		Order order1 = new Order()
			.setId(1001L)
			.setOrderLines(Arrays.asList(
				new OrderLine().setAmount(BigDecimal.valueOf(1000)),
				new OrderLine().setAmount(BigDecimal.valueOf(2000))));
		Order order2 = new Order()
			.setId(1002L)
			.setOrderLines(Arrays.asList(
				new OrderLine().setAmount(BigDecimal.valueOf(2000)),
				new OrderLine()
					.setAmount(BigDecimal.valueOf(3000))));
		Order order3 = new Order()
			.setId(1002L)
			.setOrderLines(Arrays.asList(
				new OrderLine().setAmount(BigDecimal.valueOf(1000)),
				new OrderLine().setAmount(BigDecimal.valueOf(2000))));
		List<Order> orders = Arrays.asList(order1, order2, order3);

		// TODO: find the sum of amounts
		// 오더라인들의 가격의 총 합
		BigDecimal sumOfAmounts = orders.stream()
			.map(Order::getOrderLines) // Stream<List<OrderLine>>
			.flatMap(orderLines -> orderLines.stream()) // 오더라인들을 평평하게해서 스트림으로 만듬 Stream<OrderLine>
			.map(orderLine -> orderLine.getAmount()) // Stream<BigDecimal>
			.reduce(BigDecimal.ZERO, (bigDecimal, bigDecimal2) -> bigDecimal.add(bigDecimal2));
		System.out.println("sumOfAmounts = " + sumOfAmounts);
	}
}
