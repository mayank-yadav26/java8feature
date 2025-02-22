package streamapi;

import java.util.List;

/**
 * Write a Java program that takes two lists of integers and finds the common
 * elements (intersection) using the Stream API.
 * input: 
 * List<Integer> list1 = List.of(1, 2, 3, 4, 5, 6);
 * List<Integer> list2 = List.of(4, 5, 6, 7, 8, 9);
 * output: Intersection: [4, 5, 6]
 */
public class CommonElements {
	public static void main(String[] args) {
		List<Integer> list1 = List.of(1, 2, 3, 4, 5, 6);
		List<Integer> list2 = List.of(4, 5, 6, 7, 8, 9);
		List<Integer> intersection = list1.stream()
				.filter(e -> list2.contains(e)).toList();
		// Note: you can use .toList() in java 17 but you have to use collect(Collectors.toList()) in java 8.
		System.out.println("Intersection: "+intersection);
	}
}
