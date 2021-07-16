package com.goanna;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListsTest {

	List<Employee> empList;

	
	@BeforeEach
	void Initialize() {
		Employee emp1 = new Employee(1, "Mohit", 22);
		Employee emp2 = new Employee(2, "Rahul", 42);
		Employee emp3 = new Employee(3, "Shyam", 24);
		Employee emp4 = new Employee(4, "Mohit", 36);
		Employee emp5 = new Employee(5, "Swaraj", 60);

		this.empList = new ArrayList<>(10);

		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);
		empList.add(emp4);
		empList.add(emp5);

	}

	@Test
	void testEmployeeAge() {
		Employee expected = Lists.over60(empList);
		assertEquals(expected, null);
		
		Employee emp6 = new Employee(6, "Sarah", 65);
		empList.add(emp6);	
		assertEquals(emp6, Lists.over60(empList));
		
		int age = emp6.age;
		assertEquals(65,age);
	}

	@Test
	void testRemoveEmployee() {
		Lists.removeById(empList, 4);
		assertEquals(
				"[Employee{id=1, name='Mohit', age=22}, Employee{id=2, name='Rahul', age=42}, Employee{id=3, name='Shyam', age=24}, Employee{id=5, name='Swaraj', age=60}]",	empList.toString());
	}
	
	@Test
	void testAgeModulud() {
		Boolean expectedTrue = Lists.ageModulus(empList);
		assertTrue(expectedTrue);
		
		List<Employee> newList = new ArrayList<>();
		Employee emp1 = new Employee(1, "Mohit", 23);
		Employee emp2 = new Employee(2, "Rahul", 43);
		Employee emp3 = new Employee(3, "Shyam", 25);
		
		newList.add(emp1);
		newList.add(emp2);
		newList.add(emp3);
		
		
		Boolean expectedFalse = Lists.ageModulus(newList);
		assertFalse(expectedFalse);
	}

}
