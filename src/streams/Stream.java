package streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

/**
 * @author wangzhiping movingwzp@gmail.com
 * @date 201/08/19 15:20
 * @brief learning the new feature of java8 - stream
 *
 * 把函数式风格引入了java
 */
public class Stream {
	public static void main(String[] args) {
		List<Student> sourcedata = getData();
		
		// 需求1 ： M（男性） W（女性） 按照从小到大给男性排序
		// before java8
		List<Student> datanew = new ArrayList<Student>();
		for (Student s : sourcedata) {
			if (s.getSex() == 'M') {
				datanew.add(s);
			}
		}
		Collections.sort(datanew, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o1.getAge() - o2.getAge();
			}
		});
		//showData(datanew);
		
		// java8 in stream
		List<Student> result = sourcedata.stream().	
							   filter(e -> e.getSex() == 'M').
							   sorted( (Student s1, Student s2) -> (s1.getAge() - (s2.getAge())) ).
							   // sorted( (s1, s2) -> (s1.getAge() - (s2.getAge())) ).
							   collect(Collectors.toList());
		//showData(result);
		
		// learning strem api in detail
		// problem 1 - 男性平均年龄
		OptionalDouble resultage  = sourcedata.stream().
									filter(e -> e.getSex() == 'M').
									mapToInt(e -> e.getAge()).
									average();
		System.out.println(resultage);
		
		// reduce :  提供一个初始种子和运算规则，依照运算规则，依次跟第一个，第二个。。。元素进行组合，返回结果 包括：sum max min
		int resultagetwo = sourcedata.stream().
						   filter(e -> e.getSex() == 'M').
						   mapToInt(e -> e.getAge()).
						   reduce(0, Integer::max);
		System.out.println(resultagetwo);
		
		// map : 获取所有人的名字大写
		List<String> resultname = sourcedata.stream().
						map(e -> e.getName().toUpperCase()).
						sorted().
						collect(Collectors.toList());
		System.out.println(resultname);	
		
		
		// forEach 遍历每一个元素并做相应的修改，并行状态下无法保证遍历的元素次序，多线程安全
		sourcedata.stream().forEach(e -> e.setName("new name"));
		showData(sourcedata);
	}
	private static void showData(List<Student> data) {
		for (Student s : data) {
			System.out.println(s);
		}
	}
	
	private static List<Student> getData() {
		List<Student> result = new ArrayList<Student>();
		result.add(new Student("wang1", 22, 'M'));
		result.add(new Student("wang2", 35, 'W'));
		result.add(new Student("wang3", 12, 'M'));
		result.add(new Student("wang4", 52, 'W'));
		result.add(new Student("zhang1", 35, 'M'));
		result.add(new Student("zhang2", 21, 'W'));
		result.add(new Student("zhang4", 34, 'M'));
		result.add(new Student("li3", 12, 'W'));
		result.add(new Student("li4", 23, 'M'));
		result.add(new Student("li9", 34, 'W'));
		result.add(new Student("li1", 16, 'M'));
		return result;
	}
}
