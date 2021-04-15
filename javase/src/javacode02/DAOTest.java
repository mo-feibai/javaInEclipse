package javacode02;

import java.util.List;

public class DAOTest {
	public static void main(String[] args) {
		DAO<User> dao = new DAO<>();
		dao.save("1001", new User(1001, 23, "Tom White"));
		dao.save("1002", new User(1002, 21, "Candy Bob"));
		dao.save("1003", new User(1003, 20, "Sindy MOnth"));
		System.out.println(dao.get("1001"));
		List<User> list = dao.list();
		System.out.println(list);
		dao.update("1001", new User(1231, 19, "Lucy Del"));
		System.out.println(dao.list());
	}
}
