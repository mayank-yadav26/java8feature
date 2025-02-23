package streamapi;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * 📌 Find the Kth Largest Element in a List using Streams 💡 Problem Statement:
 * Given a list of integers and a number k, find the kth largest unique element
 * using Java Streams.
 */
public class KthLargestElement {
	public static void main(String[] args) {
		List<Integer> list = List.of(10, 20, 10, 30, 20, 40, 50);
		int k = 2; // Find the 2nd largest unique element

		Optional<Integer> kthLargest = list.stream().distinct() // Remove duplicates
				.sorted(Comparator.reverseOrder()) // Sort in descending order
				.skip(k - 1) // Skip first (k-1) elements
				.findFirst(); // Pick the next one as the kth largest

		kthLargest.ifPresentOrElse(num -> System.out.println(k + "th largest unique element: " + num),
				() -> System.out.println("Not enough unique elements!"));
	}
}
