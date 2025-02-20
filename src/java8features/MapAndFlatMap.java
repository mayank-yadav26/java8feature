package java8features;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MapAndFlatMap {
	public static void main(String[] args) {
		// Data setup
		Employee emp1 = new Employee("Mayank", "DMS", 1000, 21);
		ArrayList<String> phoneNumbers = new ArrayList<>();
		phoneNumbers.add("1234");
		phoneNumbers.add("3456");
		emp1.setPhoneNumbers(phoneNumbers);
		Employee emp2 = new Employee("Tanya", "Collections", 2000, 21);
		emp2.setPhoneNumbers(phoneNumbers);
		Employee emp3 = new Employee("Sachin", "DMS", 500, 21);
		emp3.setPhoneNumbers(phoneNumbers);

		List<Employee> empList = new ArrayList<>();
		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);

		// Data Setup done............

		// emp -> emp.getEmpName : one to one mapping
		List<String> empNames = empList.stream().map(emp -> emp.getEmpName()).collect(Collectors.toList());
		System.out.println(empNames);

		// emp->emp.getPhoneNumbers() : one to many mapping
		List<List<String>> phoneNumList = empList.stream().map(emp -> emp.getPhoneNumbers())
				.collect(Collectors.toList());
		System.out.println(phoneNumList); // return List of List
		
		// using flat map, we will get list of strings not list of list.
		List<String> phoneNums = empList.stream()
				.flatMap(emp -> emp.getPhoneNumbers().stream())
				.collect(Collectors.toList());
		System.out.println(phoneNums); // return List of List

	}
}
