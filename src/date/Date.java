package date;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @author wangzhiping movingdaywzp@gmail.com
 * @date 2016/08/19 12:58
 * @brief learning the new feature of time/date of java8
 * immutable and thread-safe
 */
public class Date {
	public static void main(String[] args) {
		// today
		LocalDate today = LocalDate.now();
		System.out.println("today : " + today);
	
		// special day
		//LocalDate specialday = LocalDate.of(2016, 1, 22);
		LocalDate specialday = LocalDate.of(2016, Month.JANUARY, 22);
		System.out.println("speciaday : " + specialday);
		
		LocalDate tenthDay2016 = LocalDate.ofYearDay(2016, 10);
		System.out.println("10th day of 2016 : " + tenthDay2016);
		
		// 解析
		// default format
		LocalDate parse = LocalDate.parse("2016-08-19");
		System.out.println("default format of (yyyy-MM-dd) : " + parse);
		
		// pattern format
		LocalDate specialFormat = LocalDate.parse("2016/08/19",
				DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		System.out.println("special format : " + specialFormat);
		
		// 格式化输出
		// default output
		System.out.println("default output (yyyy-MM-dd) : " + LocalDate.now());
		
		// pattern output
		System.out.println("pattern output (yyyy/MM/dd) : " + LocalDate.now().
				format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
		
		//  计算
		// 前几天， 后几天
		System.out.println("5 days ago : " + today.minus(5, ChronoUnit.DAYS));
		System.out.println("5 days ago : " + today.minusDays(5));
		System.out.println("5 days later : " + today.plus(5, ChronoUnit.DAYS));
		
	}
}
