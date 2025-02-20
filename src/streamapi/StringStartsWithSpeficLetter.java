package streamapi;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a list of strings, write a Java 8 program to count the number of
 * strings that start with a specific letter (e.g., 'a') using Streams.
 */
public class StringStartsWithSpeficLetter {
	public static void main(String[] args) {
		List<String> list = List.of("abc","bcdef","acde","bcdged","b","zac");
		String startsWith = "b";
		int count = list.stream().filter(s->s.startsWith(startsWith))
				.collect(Collectors.toList()).size();
		System.out.println("Count : "+count);
		
		// or more efficient way
		long count2 = list.stream().filter(s->s.startsWith(startsWith))
		.count();
		System.out.println("count2 : "+count2);
		
	}
}
