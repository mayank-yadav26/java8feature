package streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Find the top 3 most frequently occurring words in a given sentence using Java
 * 8 Streams.
 * Input:
 * String sentence = "Java Streams make Java coding efficient and Java is fun with Streams and Streams";
 * Output:
 * Top 3 most frequent words: Streams (3), Java (3), and (2)
 */
public class Top3FrequentWords {
	public static void main(String[] args) {
		String sentence = "Java Streams make Java coding efficient and Java is fun with Streams and Streams";

        // Split sentence into words, count occurrences, and sort by frequency
        List<Map.Entry<String, Long>> topWords = Arrays.stream(sentence.split("\\s+"))
                .map(word -> word.replaceAll("[^a-zA-Z]", "")) // Remove punctuation
                .map(String::toLowerCase) // Convert to lowercase for case-insensitive counting
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue())) // Sort by frequency in descending order
                .limit(3) // Get top 3 words
                .collect(Collectors.toList());
        
        // Print result
        System.out.print("Top 3 most frequent words: ");
        System.out.println(topWords.stream()
                .map(entry -> entry.getKey() + " (" + entry.getValue() + ")")
                .collect(Collectors.joining(", ")));

	}
}
