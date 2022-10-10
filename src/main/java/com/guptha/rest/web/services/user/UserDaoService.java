package com.guptha.rest.web.services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();

	public static int userCount = 0;

	static {
		users.add(new User(++userCount, "guptha", LocalDate.now().minusYears(22)));
		users.add(new User(++userCount, "rajesh", LocalDate.now().minusYears(23)));
		users.add(new User(++userCount, "ratnaji", LocalDate.now().minusYears(20)));
	}

	public List<User> findAll() {
		return users;
	}

	public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId() == id;
		return users.stream().filter(predicate).findFirst().orElse(null);
	}

	public User save(User user) {
		user.setId(++userCount);
		users.add(user);
		return user;
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		Predicate<? super User> predicate = user -> user.getId() == id;
		users.removeIf(predicate);
	}
}