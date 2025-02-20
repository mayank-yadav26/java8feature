package streamapi;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Given a list of integers, write a Java 8 program to find the first
 * non-repeating element using Streams.
 */
public class FirstNonRepeatingElement {
	public static void main(String[] args) {
		List<Integer> list = List.of(4, 5, 1, 2, 0, 4, 5, 2, 1, 3);

		Optional<Integer> firstNonRepeating = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) // Count
																												// occurrences
				.entrySet().stream().filter(entry -> entry.getValue() == 1) // Keep only non-repeating elements
				.map(Map.Entry::getKey).findFirst(); // Get the first non-repeating element

		firstNonRepeating.ifPresentOrElse(num -> System.out.println("First non-repeating number: " + num),
				() -> System.out.println("No non-repeating number found"));
	}
}
