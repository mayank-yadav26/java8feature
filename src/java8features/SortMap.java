package java8features;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortMap {
	public static void main(String[] args) {
		Employee emp1 = new Employee("Mayank","DMS",1000,21);
		Employee emp2 = new Employee("Tanya","Collections",2000,21);
		Employee emp3 = new Employee("Sachin","DMS",500,21);
		Map<Employee,Integer> empMap = new HashMap<>();
		empMap.put(emp1, 1002);
		empMap.put(emp2, 1001);
		empMap.put(emp3, 1003);
		
		// Before sort
		System.out.println(empMap);
		
		// Without using stream API
		List<Entry<Employee,Integer>> entries = new ArrayList<>(empMap.entrySet());
		Collections.sort(entries,(o1,o2)->o2.getKey().empName.compareTo(o1.getKey().getEmpName()));
		System.out.println(entries);
		
		// With using stream API
		empMap.entrySet().stream()
		.sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getSalary).reversed()))
		.forEach(System.out::println);
	}
}
