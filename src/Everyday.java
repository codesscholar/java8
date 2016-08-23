import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Everyday {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("da", "cc", "ab", "vd");
		List<Integer> listnew = list.stream().
			filter(e -> e.startsWith("a")).
			map(e -> e.length()).
			collect(Collectors.toList());
		System.out.println(listnew);
	}
}