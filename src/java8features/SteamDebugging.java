package java8features;

import java.util.List;
import java.util.stream.Collectors;

public class SteamDebugging {
	public static void main(String[] args) {
		List<String> empList = EmployeeDatabase.getEmployees()
		.stream()
		.filter(employee->employee.getSalary()>4000)
		.map(Employee::getEmpName)
		.distinct()
		.sorted()
		.peek(System.out::println)
		.collect(Collectors.toList());
		
		//empList.stream().forEach(System.out::println);
		
		System.out.println("End of program");
	}
}
