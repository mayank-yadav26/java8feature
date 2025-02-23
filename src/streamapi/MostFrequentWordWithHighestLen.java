package streamapi;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Find the Most Frequent Word with the Highest Length
 * 
 * 💡 Problem Statement: Given a list of words, find the most frequent word. If
 * multiple words have the same highest frequency, return the one with the
 * highest length.
 */
public class MostFrequentWordWithHighestLen {
    public static void main(String[] args) {
        List<String> words = List.of("apple", "banana", "apple", "orange", "banana", "banana", "pineapple","kiwi", "pineapple", "pineapple");

        Optional<Map.Entry<String, Long>> mostFrequentLongestWord = words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) // Count occurrences
                .entrySet().stream()
                .sorted((a, b) -> {
                    int freqCompare = b.getValue().compareTo(a.getValue()); // Sort by frequency (descending)
                    return freqCompare != 0 ? freqCompare : Integer.compare(b.getKey().length(), a.getKey().length()); // If frequency is same, sort by length (descending)
                })
                .findFirst();

        mostFrequentLongestWord.ifPresent(entry -> 
            System.out.println("Most frequent word (with highest length if tied): " + entry.getKey())
        );
    }
}
