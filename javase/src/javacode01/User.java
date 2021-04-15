package javacode01;

public class User implements Comparable<Object> {
	String name;
	int age;

	public User() {
		super();
	}

	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("User.equals()");
		if (this == obj)
			return true;
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	// 按照姓名从小到大排列,如果姓名相同，按年龄从大到小排列
	@Override
	public int compareTo(Object o) {
		if (o instanceof User) {
			User user = (User) o;
			int nameCompare = this.name.compareTo(user.name);
			if (nameCompare == 0) {
				if (this.age > user.age) {
					return -1;
				} else if (this.age < user.age) {
					return 1;
				} else {
					return 0;
				}
			}
			return nameCompare;
		}
		throw new RuntimeException("参数类型错误！");
	}

}
