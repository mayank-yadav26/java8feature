package streamapi;

import java.util.List;

/**
 * Given a list of integers, write a Java 8 program to find and return the sum
 * of all even numbers using Streams.
 */
public class SumOfEvenNumbers {
	public static void main(String[] args) {
		List<Integer> list = List.of(2,3,5,2,765,23,12,543,24);
		int sum = list.stream().filter(num -> num%2==0)
				.mapToInt(Integer::intValue) // Convert Stream<Integer> to IntStream
				.sum(); // Works correctly with IntStream
		System.out.println("even sum :"+sum);
		
		// or 
		sum = list.stream().filter(num -> num%2==0)
				.mapToInt(num->num)  // Lambda instead of Integer::intValue
				.sum();
		System.out.println("even sum :"+sum);
		
		// or 
		sum = list.stream()
	              .filter(num -> num % 2 == 0)
	              .reduce(0, Integer::sum); // Sum up the filtered even numbers
		System.out.println("even sum :"+sum);

		// or 
		sum = list.stream()
	              .filter(num -> num % 2 == 0)
	              .reduce(0, (a, b) -> a + b); // Lambda instead of Integer::sum
		System.out.println("even sum :"+sum);
	}
}
