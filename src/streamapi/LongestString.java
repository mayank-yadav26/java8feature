package streamapi;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Given a list of strings, write a Java 8 program to find and return the
 * longest string using Streams.
 */
public class LongestString {
	public static void main(String[] args) {
		List<String> list = List.of("abc","acdef","acde","acdged","z","zac");
		// This is wrong because here we are comparing strings not its length;
		Optional<String> ans = list.stream().sorted((a,b)-> b.compareTo(a))
		.findFirst();
		ans.ifPresent(s -> System.out.println("ans: "+s));
		
		// More efficient way
		Optional<String> ans2 = list.stream().max((a,b)->Integer.compare(a.length(), b.length()));
		ans2.ifPresent(s -> System.out.println("ans2: "+s));
		
		// Another way
		Optional<String> ans3 = list.stream().max(Comparator.comparingInt(String::length));
		ans3.ifPresent(s -> System.out.println("ans3: "+s));
	}
}
