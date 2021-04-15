package javacode02;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.Test;

public class BlackFridayDays {
	public void getBlackFridayDays(int startYear, int endYear) {
		Calendar calendar = Calendar.getInstance();
		int days = 0;
		for (int i = startYear; i <= endYear; i++) {
			calendar.set(Calendar.YEAR, i);
			calendar.set(Calendar.DATE, 13);

			for (int j = 0; j <= 11; j++) {
				calendar.set(Calendar.MONTH, j);
				if (calendar.get(Calendar.DAY_OF_WEEK) == 6) {
					days++;
					System.out.println(i + "年" + (j + 1) + "月13日为第" + days + "个黑色星期五");
				}
			}
		}
	}

	@Test
	void testName() throws Exception {
		getBlackFridayDays(2019, 2021);
	}
}
