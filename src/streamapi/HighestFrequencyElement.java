package streamapi;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Given a list of integers, write a Java 8 program to find the element with the
 * highest frequency using Streams.
 */
public class HighestFrequencyElement {
	public static void main(String[] args) {
		List<Integer> list = List.of(2, 3, 5, 2, 4, 3, 3, 765, 23, 12, 543, 24);
		Optional<Entry<Integer, Long>> max = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.max((a, b) -> a.getValue().compareTo(b.getValue()));
		max.ifPresent(entry -> System.out.println("max:" + entry.getKey()));

		// or
		max = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.max(Map.Entry.comparingByValue()); // Cleaner comparison
		// or .max(Comparator.comparingLong(Map.Entry::getValue))
		max.ifPresent(entry -> System.out.println("Highest frequency element: " + entry.getKey()));
	}
}
