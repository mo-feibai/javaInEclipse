package javacode01;

interface Info {
	void show();
}

enum SeasonEnum implements Info {
	SPRING("春天", "春暖花开") {
		@Override
		public void show() {
			System.out.println("这是春天");
		}
	},
	SUMMER("夏天", "夏日炎炎") {
		@Override
		public void show() {
			System.out.println("这是夏天");
		}
	},
	AUTUMN("秋天", "落叶金黄") {
		@Override
		public void show() {
			System.out.println("这是秋天");

		}
	},
	WINTER("冬天", "冬雪飘飘") {
		@Override
		public void show() {
			System.out.println("这是冬天");

		}
	};

	private final String seasonName;
	private final String seasonDesc;

	private SeasonEnum(String seasonName, String seasonDesc) {
		this.seasonName = seasonName;
		this.seasonDesc = seasonDesc;
	}

	public String getSeasonName() {
		return seasonName;
	}

	public String getSeasonDesc() {
		return seasonDesc;
	}

	@Override
	public String toString() {
		return seasonName + ":" + seasonDesc;

	}

	/*
	 * @Override public void show() { System.out.println("这是一个季节。"); }
	 */

}
