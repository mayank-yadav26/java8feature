package java8features;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EmployeeDatabase {
	
	public static List<Employee> getEmployees(){
		List<Employee> empList = new ArrayList<>();
		for(int i=0;i<1000;i++) {
			empList.add(new Employee("Employee Name: "+i,"Department:"+i,new Random().nextInt(100000),i));
		}
		return empList;
	}
}
