package java8features;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MapReduce {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(2,4,1,5,7,3);
		List<String> words = Arrays.asList("mayank","rahul","ravi","ankit");
		int sum=0;
		for(int i : numbers) {
			sum+=i;
		}
		System.out.println(sum);
		
		int sum1 = numbers.stream().mapToInt(i->i).sum();
		System.out.println(sum1);
		
		int sum2 = numbers.stream().reduce(0,(a,b)->a+b);
		System.out.println(sum2);
		
		Optional<Integer> sum3 = numbers.stream().reduce(Integer::sum);
		System.out.println(sum3.get());
		
		Integer maxValue = numbers.stream().reduce(Integer.MIN_VALUE,(a,b)->a>b?a:b);
		System.out.println("Max value is "+maxValue);
		
		Integer maxValue2 = numbers.stream().reduce(Integer::max).get();
		System.out.println(maxValue2);
		
		String longestName = words.stream()
				.reduce((word1,word2)->word1.length()>word2.length()?word1:word2)
				.get();
		System.out.println(longestName);
		
		
		
	}
}
