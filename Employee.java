package java8features;

import java.util.List;

public class Employee {
	String empName;
	String department;
	int salary;
	int age;
	List<String> phoneNumbers;
	
	
	public Employee() {
		super();
	}

	public Employee(String empName, String department, int salary, int age) {
		super();
		this.empName = empName;
		this.department = department;
		this.salary = salary;
		this.age = age;
	}
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", department=" + department + ", salary=" + salary + ", age=" + age
				+ "]";
	}
	
}
