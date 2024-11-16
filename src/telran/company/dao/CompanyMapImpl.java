package telran.company.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import telran.company.model.Employee;
import telran.company.model.SalesManager;

public class CompanyMapImpl implements Company {
	String name;
	Map<Integer, Employee> employees;
	int capacity;

	public CompanyMapImpl(int capacity) {
		this.capacity = capacity;
		employees = new HashMap<>();
	}

	// O(1)
	@Override
	public boolean addEmployee(Employee employee) {
		if (employee == null || capacity == employees.size() || findEmployee(employee.getId()) != null) {
			return false;
		}
		return employees.putIfAbsent(employee.getId(), employee) == null;

	}

	// O(1)
	@Override
	public Employee removeEmployee(int id) {

		return employees.remove(id);
	}

	// O(1)
	@Override
	public Employee findEmployee(int id) {
		return employees.get(id);
	}

	// O(n)
	@Override
	public double totalSalary() {
		double sum = 0;
		for (Employee employee : employees.values()) {
			sum += employee.calcSalary();
		}
		return sum;
	}

	// O(n)
	@Override
	public double averageSalary() {
		return totalSalary() / employees.size();
	}
	
	// O(n)
	@Override
	public double totalSales() {
		double sum = 0;

		for (Employee employee : employees.values()) {
			if (employee instanceof SalesManager) {
				sum += ((SalesManager) employee).getSalesValue();
			}
		}
		return sum;
	}

	//O(1)
	@Override
	public int size() {
		return employees.size();
	}
	// O(n)
	@Override
	public void printEmployees() {
		for (Employee employee : employees.values()) {
			System.out.println(employee);
		}

	}
	
	// O(n)
	@Override
	public Employee[] findEmployeesHoursGreateThan(int hours) {
		return findEmployeesByPredicate(e -> e.getHours() >= hours);
	}
	
	// O(n)
	@Override
	public Employee[] findEmployeesSalaryBetween(double min, double max) {

		return findEmployeesByPredicate(t -> t.calcSalary() >= min && t.calcSalary() < max);
	}
	
	// O(n)
	private Employee[] findEmployeesByPredicate(Predicate<Employee> predicate) {
		List<Employee> copyEmployees = new ArrayList<>();

		for (Employee employee : employees.values()) {
			if (predicate.test(employee)) {
				copyEmployees.add(employee);
			}
		}
		copyEmployees.sort((o1, o2) -> Integer.compare(o1.getId(), o2.getId()));
		return copyEmployees.toArray(new Employee[0]);
	}

}
