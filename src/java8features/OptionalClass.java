package java8features;

import java.util.Arrays;
import java.util.Optional;

public class OptionalClass {
	public static void main(String[] args) {
		// Data setup
		Employee emp1 = new Employee("Mayank", "DMS", 1000, 21);
		emp1.setPhoneNumbers(Arrays.asList("1234","23445"));
		
		//empty
		//of
		//ofNullable
		
//		Optional<Object> emptyOptional = Optional.empty();
//		System.out.println(emptyOptional);
	}
}
