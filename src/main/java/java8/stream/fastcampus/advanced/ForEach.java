package java8.stream.fastcampus.advanced;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;

import java8.stream.fastcampus.pojoModel.User;
import java8.stream.fastcampus.service.EmailService;

public class ForEach {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(3, 5, 2, 1);
		Consumer<Integer> numberConsumer = new Consumer<>() {
			@Override
			public void accept(Integer number) {
				System.out.println("The number is " + number);
			}
		};
		numbers.stream().forEach(numberConsumer);

		// Refactoring
		numbers.forEach(number -> System.out.println("The number is " + number));

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

		EmailService emailService = new EmailService();
		users.stream()
			.filter(user -> !user.isVerified())
			.forEach(emailService::sendVerifyYourEmail);

		for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);
			System.out.println("Do an operation on user " + user.getName() + " at index " + i);
		}
		IntStream.range(0, users.size()).forEach(i -> {
			User user = users.get(i);
			System.out.println("Do an operation on user " + user.getName() + " at index " + i);
		});
	}
}
