package javacode01;

/**
 * 枚举类的测试
 * 
 * @author mofeibai
 *
 */


class Season {

	private final String seasonName;
	private final String seasonDesc;

	private Season(String seasonName, String seasonDesc) {
		this.seasonName = seasonName;
		this.seasonDesc = seasonDesc;
	}

	public static final Season SPRING = new Season("春天", "春暖花开");
	public static final Season SUMMER = new Season("夏天", "夏日炎炎");
	public static final Season AUTUMN = new Season("秋天", "落叶金黄");
	public static final Season WINTER = new Season("冬天", "冬雪飘飘");

	public String getSeasonName() {
		return seasonName;
	}

	public String getSeasonDesc() {
		return seasonDesc;
	}

	@Override
	public String toString() {
		return "Season [seasonName=" + seasonName + ", seasonDesc=" + seasonDesc + "]";
	}

}


