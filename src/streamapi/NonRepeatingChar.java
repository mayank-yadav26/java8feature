package streamapi;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Write a Java program that takes a string and finds the first non-repeating
 * character using the Stream API. 
 * 💡 Example Input: "swiss" 
 * 💡 Example Output:'w'
 */
public class NonRepeatingChar {
	public static void main(String[] args) {
		String input = "swiss";
		Optional<Map.Entry<Character,Long>> ans = 
		input.chars().mapToObj(c->(char)c)  // Convert int stream to Character stream
		.collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
		.entrySet().stream().filter(entry->entry.getValue()==1).findFirst();
		ans.ifPresent(entry->System.out.println("char:"+entry.getKey()));
	}
}
