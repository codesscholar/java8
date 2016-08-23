package lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author wangzhiping movingdaywzp@gmail.com
 * @date 2016/08/19 11:07
 * @brief learning lambda of java8
 *
 */


public class Lambda {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("a", "c", "b", "d");
		Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> e1.compareTo( e2 ) );
		/**
		 * Sort
		 */
		// before java8
		Comparator<String> comparator = new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				// TODO Auto-generated method stub
				return a.compareTo(b);
			}
		};
		Collections.sort(names, comparator);
		// java8
		Collections.sort(names, (a, b) -> a.compareTo(b));
		names.sort( ( String a, String b) -> a.compareTo(b) );
		
		/**
		 * Iterator
		 */
		// before java8
		for (String s : names) {
			System.out.println(s);
		}
		
		//java8
		names.forEach(e -> System.out.println(e));
	}
}
