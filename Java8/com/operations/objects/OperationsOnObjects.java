package com.operations.objects;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

class Employee {

    private int id;
    private String name;
    private int salary;

    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
    
}
public class OperationsOnObjects {
	public static void main(String args[]) {
		List<Employee> employees = Arrays.asList(
                new Employee(1, "Aditya", 50000),
                new Employee(2, "Rahul", 70000),
                new Employee(3, "Amit", 60000),
                new Employee(4, "Sonakshi", 90078)
        );
		
//		Employee higestSal = employees.stream().max(Comparator.comparing(Employee::getSalary)).get();
//		System.out.println(higestSal.toString());
		
		//Employees whose salary contains the digit 7
//		employees.stream().filter(x->Integer.toString(x.getSalary())
//				.contains("7")).forEach(System.out :: println);
		
		//Sort Employees in descending order based on salary
		employees.stream().sorted((a,b)->b.getSalary()-a.getSalary()).forEach(System.out::println);
		
		//Sum of salaries
		int sumOsal = employees.stream().mapToInt(Employee::getSalary).sum();
		System.out.println("Sum of salaries "+sumOsal);
		
		OptionalDouble avgOfsal = employees.stream().mapToInt(Employee::getSalary).average();
		System.out.println("Average of salaries "+avgOfsal.getAsDouble());
		
				
		
	}
	
}
