package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
/**
 * @author wangzhiping movingwzp@gmail.com
 * @date 201/08/19 15:20
 * @brief learning the new feature of java8 - stream
 *
 */

public class Stream {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("wang1", "wang2", "zhang1", "zhang2", "li");
		List<String> newlist = list.stream().
											filter(e -> e.startsWith("w")).
											// :: 解释：左边表示类或者对象， 右边表示这个类或者对象的作用域下的函数或者方法
//											map(String::toUpperCase).
											map(e -> e.toUpperCase()).
											sorted( (e1, e2) -> (e1.compareTo(e2))).
											collect(Collectors.toList());
		Map<Integer, List<String>> map = list.stream().
													  map(String::toUpperCase).
													  collect(Collectors.groupingBy(String::length));
		
		Optional<String> string = list.stream().
												filter(e -> e.contains("i")).
												findFirst();
		System.out.println(string);
		System.out.println(map);
		System.out.println(newlist);
	}
}
