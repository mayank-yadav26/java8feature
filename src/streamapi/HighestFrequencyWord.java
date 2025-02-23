package streamapi;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 📌 Find the Most Frequent Word in a Sentence using Streams
 * input: "java is great and java is powerful and java is popular"
 * output: Most frequent word: java (3 times)
 * Write a Java program using Collectors.toMap() and Streams to solve this problem.

	✅ Constraints:

    Ignore case sensitivity (Java and java should be treated as the same).
    Words are separated by spaces.
    If multiple words have the same highest frequency, return any one of them.
 */
public class HighestFrequencyWord {
	public static void main(String[] args) {
		String sentence = "java is great and java is powerful and java is popular";
		// Using Collectors.toMap()
        Map<String, Integer> wordCount = Arrays.stream(sentence.toLowerCase().split("\\s+"))
                .collect(Collectors.toMap(
                        Function.identity(), // Key Mapper (word itself)
                        word -> 1,           // Value Mapper (initial value is 1 for each word)
                        Integer::sum         // Merge Function (sum up values if key already exists)
                ));
        Optional<Entry<String, Integer>> max = wordCount.entrySet().stream().max(Map.Entry.comparingByValue());
        max.ifPresent(entry ->
        		System.out.println("Most frequent word: " + entry.getKey() + " (" + entry.getValue() + " times)")
        );
        // Or
        Optional<Map.Entry<String, Long>> mostFrequentWord = Arrays.stream(sentence.toLowerCase().split("\\s+")) 
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) // Count occurrences
                .entrySet().stream()
                .max(Map.Entry.comparingByValue()); // Find the max by value

        mostFrequentWord.ifPresent(entry ->
                System.out.println("Most frequent word: " + entry.getKey() + " (" + entry.getValue() + " times)")
        );
	}
}
