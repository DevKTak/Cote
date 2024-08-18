package java8.stream.fastcampus.stream;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import java8.stream.fastcampus.pojoModel.Order;
import java8.stream.fastcampus.pojoModel.OrderLine;
import java8.stream.fastcampus.pojoModel.OrderLine.OrderLineType;

public class FlatMapTest {
	public static void main(String[] args) {
		String[][] cities = new String[][] {
			{"Seoul", "Busan"},
			{"San Francisco", "New York"},
			{"Madrid", "Barcelona"}
		};
		Stream<String[]> cityStream = Arrays.stream(cities); // 가장 바깥 껍데기 까짐
		Stream<Stream<String>> cityStreamStream = cityStream.map(x -> Arrays.stream(x)); // 그다음 껍데기 까짐
		List<Stream<String>> cityStreamList = cityStreamStream.toList(); // 리스트로 변경해도 안에 스트림 하나 더 남음
		System.out.println("cityStreamList = " + cityStreamList); // 원하는 그림이 아님

		Stream<String[]> cityStream2 = Arrays.stream(cities); // 가장 바깥 껍데기 까짐
		Stream<String> flattenedCityStream = cityStream2.flatMap(
			Arrays::stream); // 한번 까져있던 1차원 배열을 한번더 까면서 평평한 스트림으로 만듬
		List<String> flattenedCityList = flattenedCityStream.toList(); // 리스트로 변경
		System.out.println(flattenedCityList); // 원하는 그림

		Order order1 = new Order()
			.setId(1001)
			.setOrderLines(Arrays.asList(
				new OrderLine()
					.setId(10001)
					.setType(OrderLine.OrderLineType.PURCHASE)
					.setAmount(BigDecimal.valueOf(5000)),
				new OrderLine()
					.setId(10002)
					.setType(OrderLine.OrderLineType.PURCHASE)
					.setAmount(BigDecimal.valueOf(4000))
			));
		Order order2 = new Order()
			.setId(1002)
			.setOrderLines(Arrays.asList(
				new OrderLine()
					.setId(10003)
					.setType(OrderLineType.PURCHASE)
					.setAmount(BigDecimal.valueOf(2000)),
				new OrderLine()
					.setId(10004)
					.setType(OrderLineType.DISCOUNT)
					.setAmount(BigDecimal.valueOf(-1000))
			));
		Order order3 = new Order()
			.setId(1003)
			.setOrderLines(Arrays.asList(
				new OrderLine()
					.setId(10005)
					.setType(OrderLineType.PURCHASE)
					.setAmount(BigDecimal.valueOf(2000))
			));

		// 주문들의 OrderLine 들을 평평하게 합쳐서 나열하자
		List<Order> orders = Arrays.asList(order1, order2, order3);

		// for-loop
		/*
			List<OrderLine> mergedOrderLines = new ArrayList<>();
			for (Order order : orders) {
				List<OrderLine> orderLines = order.getOrderLines();
				for (OrderLine orderLine : orderLines) {
					mergedOrderLines.add(orderLine);
				}
			}
		 */

		// stream
		List<OrderLine> mergedOrderLines =
			orders.stream()                                   // Stream<Order>
				.map(Order::getOrderLines)                    // Stream<List<OrderLine>>
				.flatMap(
					orderLines -> orderLines.stream())   // Stream<OrderLine> , map()이 였다면 Stream<Stream<OrderLine>>
				.toList();
		System.out.println("mergedOrderLines = " + mergedOrderLines);
	}
}
