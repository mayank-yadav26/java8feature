package java8features;

import java.io.IOException;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelProcessing {
	public static void main(String[] args) throws IOException {
		long start = 0;
		long end = 0;
		
//		start = System.currentTimeMillis();
//		IntStream.range(1,100).forEach(System.out::println);
//		end = System.currentTimeMillis();
//		System.out.println("Total time : "+(end-start));
//		
//		start = System.currentTimeMillis();
//		IntStream.range(1,100).parallel().forEach(System.out::println);
//		end = System.currentTimeMillis();
//		System.out.println("Total time with parallel stream: "+(end-start));
		
		IntStream.range(1, 100).forEach(x->{
			System.out.println("Current Thread Name : "+Thread.currentThread().getName());
		});
		
		IntStream.range(1, 100).parallel().forEach(x->{
			System.out.println("Current Thread Name parallel: "+Thread.currentThread().getName());
		});
		
		
		List<Employee> employees = EmployeeDatabase.getEmployees();
		start = System.currentTimeMillis();
		double avgSalary = employees.stream().map(Employee::getSalary).mapToDouble(i->i).average().getAsDouble();
		end = System.currentTimeMillis();
		System.out.println("Normal Stream Execution TIme: "+(end-start)+" avg salary: "+avgSalary);
		
		start = System.currentTimeMillis();
		double avgSalaryWithParallelStream = employees.stream().parallel().map(Employee::getSalary).mapToDouble(i->i).average().getAsDouble();
		end = System.currentTimeMillis();
		System.out.println("Parallel Stream Execution TIme: "+(end-start)+" avg salary: "+avgSalaryWithParallelStream);
		
		start = System.currentTimeMillis();
		double avgSalaryWithParallelStream2 = employees.parallelStream().map(Employee::getSalary).mapToDouble(i->i).average().getAsDouble();
		end = System.currentTimeMillis();
		System.out.println("Parallel Stream 2 Execution TIme: "+(end-start)+" avg salary: "+avgSalaryWithParallelStream2);
		
		
	}
}
