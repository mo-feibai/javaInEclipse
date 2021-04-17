package reflection.compenent;

import act.Player;
import reflection.Person;

public class ObjectUtilTest {
	public static void main(String[] args) {
		Person person = ObjectUtil.get("Person");
		Player player = ObjectUtil.get("player");
		player.introduce();
		int age = person.getAge();
		System.out.println(age);
		person.show();
	}
}
