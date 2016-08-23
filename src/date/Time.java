package date;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
/**
 * learning the new feature of Time of java8
 * @author wangzhiping movingwzp@gmail.com
 * @date 2016/08/21 13:46
 *
 */

public class Time {
	public static void main(String[] args) {
		// Now
		LocalTime timenow = LocalTime.now();
		LocalTime time = LocalTime.now(ZoneId.of("Asia/Kolkata"));
		System.out.println("current time : " + timenow);
		System.out.println("time of zone : " + time);
		
		// Special Time( of) 
		LocalTime specialtime = LocalTime.of(11, 59);
		System.out.println("specialTime : " + specialtime);
		
		// 解析
		// default format
		LocalTime parseFromText = LocalTime.parse("11:59:59");
		System.out.println("parse from (hh:mm:ss) : " + parseFromText);
		
		//special format 注：易错点在于ofPattern的编写，要注意每个symbol的含义，比如把HH/mm/ss 写成 hh/mm/ss就会出错，可以F3进去查看具体含义
		LocalTime parseFromFormatText = LocalTime.parse("11/59/59",
				DateTimeFormatter.ofPattern("HH/mm/ss"));
		System.out.println("parse from (HH/mm/ss) : " + parseFromFormatText);
		
		// 格式化输出
		// default output
		System.out.println("default output : " + LocalTime.now());
		// special output
		System.out.println("special output : " + LocalTime.now().
				format(DateTimeFormatter.ofPattern("HH--mm??ss")));
		
		// 计算
		// 3小时5分6秒后
		System.out.println("time later : " + LocalTime.now().plusHours(3).
				plusMinutes(5).plusMinutes(6)
				.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
	}
}
