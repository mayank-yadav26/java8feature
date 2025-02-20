package streamapi;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Given a list of integers, write a Java 8 program to find and return the
 * second highest number using Streams.
 */
public class SecondHighestNum {
	public static void main(String[] args) {
		// Initial thought
		List<Integer> listNums = List.of(1,2,10,3,5,8);
		List<Integer> ansList = listNums.stream().sorted(Collections.reverseOrder()).skip(1).limit(1).collect(Collectors.toList());
		System.out.println("ans: "+ansList.get(0));
		
		// Improved version
		Optional<Integer> secHighNum = listNums.stream().sorted(Collections.reverseOrder())
		.skip(1)
		.findFirst();
		
		System.out.println("ans: "+secHighNum.get());
		secHighNum.ifPresent(num -> System.out.println("ans: "+num));
	}
}
