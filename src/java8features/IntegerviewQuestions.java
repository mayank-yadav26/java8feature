package java8features;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntegerviewQuestions {
	public static void main(String[] args) {
		IntegerviewQuestions iq = new IntegerviewQuestions();
		String input = "IloveJava";
		iq.groupElementOfString(input);
		iq.charOccurenceOfString(input);
		iq.duplicateCharsInString(input);
		iq.firstNonRepeatingElement(input);
		iq.findLongestString(input);

		int[] numbers = { 2, 33, 34, 112, 55, 84 };
		iq.findHighestNumber(numbers);

		int limitNumbers = 10;
		iq.generateStreamOfEvenNum(limitNumbers);
		
		iq.skipElements();
		iq.listToString();
		iq.staticsInformation();

	}

	private void staticsInformation() {
		List<Employee> empList = EmployeeDatabase.getEmployees();
		IntSummaryStatistics statistics = 
				empList.stream()
				.collect(Collectors.summarizingInt(Employee::getSalary));
		System.out.println("statistics is : "+statistics);
	}

	private void listToString() {
		List<Employee> empList = EmployeeDatabase.getEmployees();
		String namesString = empList.stream().map(Employee::getEmpName).collect(Collectors.joining(", ", "[", "]"));
		System.out.println("names string is : "+namesString);
	}

	private void skipElements() {
		// second even element out of list
		List<Integer> evenNums = Stream.of(1,2,3,4,5,6,7,8)
		.filter(num->num%2==0)
		.skip(1)
		.limit(1)
		.collect(Collectors.toList());
		System.out.println();
		evenNums.forEach(System.out::println);
	}

	private void generateStreamOfEvenNum(int limitNumbers) {
		Stream<Integer> evenNumStream = Stream.iterate(0, num -> num + 2).limit(limitNumbers);
		// evenNumStream.forEach(System.out::println); // if this is used then below
		// code will throw exception because stream is already use
		List<Integer> evenNumb = evenNumStream.collect(Collectors.toList());
		evenNumb.forEach(num->System.out.print(" "+num));
		
		Stream<Integer> randomNumGenerator = Stream.generate(()->new Random().nextInt(100, 500)).limit(10);
		System.out.println("\nTo generate 10 random number b/w 100 and 500");
		randomNumGenerator.forEach(num->System.out.print(" "+num));
	}

	/**
	 * Find highest number
	 * 
	 * @param numbers
	 */
	private void findHighestNumber(int[] numbers) {
		int highestNumber = Arrays.stream(numbers).reduce((a, b) -> a > b ? a : b).getAsInt();
		System.out.println("Highest number is : " + highestNumber);
	}

	/**
	 * Find longest string from given array
	 * 
	 * @param input
	 */
	private void findLongestString(String input) {
		String[] strArray = { "Java", "Python", "Ruby", "C" };
		String longestString = Arrays.stream(strArray).reduce((a, b) -> a.length() > b.length() ? a : b).get();
		System.out.println("Longest String : " + longestString);
	}

	/**
	 * Find first element in a string which is none repeat
	 * 
	 * @param input
	 */
	private void firstNonRepeatingElement(String input) {
		String firstNonRepeatElement = Arrays.stream(input.split(""))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(x -> x.getValue() == 1).findFirst().get().getKey();

		System.out.println("First non repeating element : " + firstNonRepeatElement);

	}

	/**
	 * Find duplicate characters in a string
	 * 
	 * @param input
	 */
	private void duplicateCharsInString(String input) {

		List<String> dublicateChar = Arrays.stream(input.split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(x -> x.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());

		System.out.println("Duplicate Characters : " + dublicateChar);
	}

	/**
	 * Find character occurrences in a string
	 * 
	 * @param input
	 */
	private void charOccurenceOfString(String input) {
		Map<String, Long> charCountMap = Arrays.stream(input.split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("Map of char and its count : " + charCountMap);
	}

	/**
	 * Group all similar characters of a string
	 * 
	 * @param input
	 */
	private void groupElementOfString(String input) {
		Map<String, List<String>> nameMap = Arrays.stream(input.split("")).collect(Collectors.groupingBy(s -> s));
		System.out.println("Map of char and its total chars list : " + nameMap);
	}
}
