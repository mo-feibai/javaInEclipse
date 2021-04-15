package reflection;

import java.io.Serializable;

public class Creature<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4733469972580145175L;
	private char gender;
	public double weight;

	private void breath() {
		System.out.println("生物呼吸");
	}

	public void eat() {
		System.out.println("生物吃东西");
	}
}
