package streamapi;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Given a list of integers, write a Java 8 program to find the second most
 * frequent element using Streams.
 */
public class SecondMostFrequentElement {
	public static void main(String[] args) {
		List<Integer> list = List.of(2, 3, 5, 2, 4, 3, 3, 765, 23, 12, 543, 24);
		Optional<Map.Entry<Integer,Long>> secMax = list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
		.entrySet().stream().sorted((a,b)->b.getValue().compareTo(a.getValue()))
		.skip(1).findFirst();
		
		// or 
		// .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
		// .sorted(Map.Entry.<Integer, Long>comparingByValue(Comparator.reverseOrder()))
		// Instead of: .skip(1).findFirst() use .limit(2).reduce((first, second) -> second)
		secMax.ifPresent(entry->System.out.println("sec max freq element:"+entry.getKey()));
	}
}
