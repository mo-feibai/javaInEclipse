package javaexer;

public class Student {
	private static int nowId = 1000;
	private String name;
	private double score;
	private int id;

	public Student() {
		super();
		this.id = nowId++;
	}

	public Student(String name, double score) {
		super();
		this.name = name;
		this.score = score;
		this.id = nowId++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + ", id=" + id + "]";
	}

}
