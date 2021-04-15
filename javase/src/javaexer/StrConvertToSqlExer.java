package javaexer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
 * 将字符串"2017-08-16"转换为对应的java.sql.Date类的对象
 */
public class StrConvertToSqlExer {
	public static void main(String[] args) throws ParseException {
			String string =  "2017-08-16";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date parse = simpleDateFormat.parse(string);
			java.sql.Date date = new java.sql.Date(parse.getTime());
			System.out.println(date);
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate = LocalDate.parse(string, formatter);
			java.sql.Date date2 = java.sql.Date.valueOf(localDate);
			System.out.println(date2);
			
	}
}
