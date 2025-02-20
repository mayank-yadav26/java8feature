package java8features;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortList {
	public static void main(String[] args) {
		List<String> namesList = new ArrayList<>();
		namesList.add("Mayank");
		namesList.add("Rahul");
		namesList.add("Ravi");
		namesList.add("Ankit");
		namesList.add("Gourav");
		namesList.add("Arun");
		
		// sorting using collections
		Collections.sort(namesList);
		namesList.forEach(n->System.out.println(n));
		
		System.out.println();
		// sort in reverse order
		Collections.sort(namesList,Collections.reverseOrder());
		namesList.forEach(n->System.out.println(n));
		
		System.out.println();
		// sort using stream api
		namesList = namesList.stream().sorted().collect(Collectors.toList());
		namesList.forEach(n->System.out.println(n));
		
		System.out.println();
		// sort in reverse order using stream api
		namesList.stream().sorted(Comparator.reverseOrder()).forEach(name->System.out.println(name));
		
		
		Employee emp1 = new Employee("Mayank","DMS",1000,21);
		Employee emp2 = new Employee("Tanya","Collections",2000,21);
		Employee emp3 = new Employee("Sachin","DMS",500,21);
		
		List<Employee> empList = new ArrayList<>();
		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);
		
		
		// before sort
		System.out.println("\nBefore sort");
		empList.stream().forEach(emp->System.out.println(emp.getEmpName()));
		
		// after sort
		Collections.sort(empList,(o1,o2)->o1.getEmpName().compareTo(o2.getEmpName()));
		System.out.println("\nAfter sort");
		empList.stream().forEach(emp->System.out.println(emp.getEmpName()));
		
		// sort in reverse order
		Collections.sort(empList,(o1,o2)->o2.getEmpName().compareTo(o1.getEmpName()));
		System.out.println("\nAfter sort reverse order ");
		empList.stream().forEach(emp->System.out.println(emp.getEmpName()));
		
		// sort using stream API
		System.out.println("\nSort by name using stream API");
		empList.stream().sorted(Comparator.comparing(emp->emp.getEmpName())).forEach(System.out::println);
		
		System.out.println("\nSort by salary using stream API and method referencing");
		empList.stream().sorted(Comparator.comparing(Employee::getSalary)).forEach(System.out::println);
		
		System.out.println("\nSort by salary using stream API in reverse order and method referencing");
		empList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).forEach(System.out::println);
		
	}
}
