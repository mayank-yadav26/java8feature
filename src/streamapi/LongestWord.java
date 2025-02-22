package streamapi;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;

/**
 * Write a Java program that takes a sentence as input and finds the longest
 * word using the Stream API.
 * Input:
 * String sentence = "Java Streams provide a functional approach to processing collections of data";
 * Output:
 * Longest word: processing
 */
public class LongestWord {
	public static void main(String[] args) {
		String sentence = "Java Streams provide a functional approach to processing collections of data";
		Optional<String> ans = Arrays.stream(sentence.split(" ")).max((a,b)-> Integer.compare(a.length(), b.length()));
		ans.ifPresent(s->System.out.println("word:"+s));
		
		// or 
		ans = Arrays.stream(sentence.split("\\s+")).max(Comparator.comparingInt(String::length));
		ans.ifPresent(s->System.out.println("word:"+s));
		
		// second longest word
		
		ans = Arrays.stream(sentence.split("\\s+")).sorted(Comparator.comparingInt(String::length).reversed()).skip(1).findFirst();
		ans.ifPresent(s->System.out.println("second word:"+s));
		
		ans = Arrays.stream(sentence.split("\\s+"))
				.sorted(Comparator.comparingInt(String::length).reversed()
				.thenComparing(word -> sentence.indexOf(word))) // Maintain original order
				.skip(1).findFirst();
		ans.ifPresent(s->System.out.println("second word:"+s));
	}
}
