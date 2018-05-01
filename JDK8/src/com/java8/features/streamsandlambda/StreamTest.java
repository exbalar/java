package com.java8.features.streamsandlambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee{
	
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Employee(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		System.out.println("this is called");
		return this.name;
	}
	
	@Override
	public boolean equals(Object obj) {
		Employee e = (Employee) obj;
		System.out.println("called::"+e.getName().compareTo(this.getName()));
		if(e.getName().compareTo(this.getName()) == 0) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public int hashCode() {
		return this.getName().hashCode();
	}
	
}
public class StreamTest {


	static List<Employee> list = Arrays.asList(
			new Employee("Bala", 27),
			new Employee("Bala", 27),
			new Employee("Meena", 27),
			new Employee("Raja", 45));
	
	static List<String> listUnsorted = Arrays.asList(
			new String("Bala"),
			new String("Meena"),
			new String("raja"),
			new String("xyj")
			);
	
	private static void createSteamanduseMethodReference() {
		
		Stream<Employee> employeeList = list.stream().distinct();
		employeeList.forEach(System.out::println);
		
	}
	
	private static void createSteamanduseLambda() {
		
		Stream<Employee> employeeList = list.stream().distinct();
		//uses Consumer interface and implement apply method
		employeeList.forEach(obj -> System.out.println(obj.getName()));
		
	}
	
	private static void filterbasedonage() {
		Stream<Employee> employeeList = list.stream().map((employeeIn) -> {
			return new Employee(employeeIn.getName()+"@@",employeeIn.getAge());
		}).filter(employeeObj -> employeeObj.getAge() > 29);
		employeeList.forEach(System.out::println);
	}
	
	private static void useFlatMaptoGroup() {
		Map<Integer,List<Employee>> employeeList = list.stream().filter(objj -> {
				return objj.getName().contains("al");}
			).distinct().collect(Collectors.groupingBy(obj -> obj.getAge()));
		
		employeeList.forEach((intg,listEmp) -> {
			listEmp.forEach(emp -> System.out.println(emp.getName()));
		});
	}
	
	private static void acceptFunction(Function<String,String> input,String text) {
		System.out.println(input.apply(text));
	}
	
	private static void sort() {
		ArrayList<String> sortedl = new ArrayList<>();
		listUnsorted.stream().forEach(obj -> sortedl.add(obj.substring(0, 1).toUpperCase()+obj.substring(1)));
		sortedl.sort(String::compareTo);
		sortedl.forEach(System.out::println);

	}
	
	private static void sortUsingChained() {
		listUnsorted.stream().map(obj -> obj.substring(0, 1).toUpperCase()+obj.substring(1))
		.peek(System.out::println).sorted().forEach(System.out::println);
	}
	
	private static void sortUsingChainedandCount() {
		Long count = listUnsorted.stream().map(obj -> obj.substring(0, 1).toUpperCase()+obj.substring(1))
		.filter(text -> {
			if (text.contains("a")) {
				return true;
			}
			return false;
		}
		).count();
		System.out.println(count);
		}
	private static void sortUsingChainedandGrouping() {
		Map<Integer, List<String>> names = listUnsorted.stream().map(obj -> obj.substring(0, 1).toUpperCase()+obj.substring(1))
		.collect(Collectors.groupingBy(text -> text.length() ));
		
		//.sorted().forEach(System.out::println);
	}
	public static void main(String[] args) {
		createSteamanduseMethodReference();
		createSteamanduseLambda();
		filterbasedonage();
		//useFlatMaptoGroup();
		Function<String,String> func = text -> {
			return text.substring(0,2);
		};
		//acceptFunction(func,"1234567");
		//sort();
		//sortUsingChained();
		//sortUsingChainedandCount();
		
	}

}
