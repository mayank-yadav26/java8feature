package java8features;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class BiFunctions {
	public static void main(String[] args) {
		
		 BiFunction<String, String, String> biFunction = (s1, s2) -> s1 + s2;
		 System.out.println(biFunction.apply("Hello", "World"));

		 BiConsumer<String, Integer> biConsumer = (s, i) -> System.out.println(s + " " + i);
		 biConsumer.accept("Hello", 10);

		 BiPredicate<String, Integer> biPredicate = (s, i) -> s.length() > i;
		 System.out.println(biPredicate.test("Hello", 3));
		
		System.out.println("End of program");
		
		 BiFunction<String, String, String> biFunction2 = (s1, s2) -> s1 + s2;
		 System.out.println(biFunction2.apply("Hello", "World"));
	}
}
