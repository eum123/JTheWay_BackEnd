package net.haaim.web.common;

public class UserHelper {
	public static User getUser() {
		return new User("id", Role.MANAGER);
	}
}
