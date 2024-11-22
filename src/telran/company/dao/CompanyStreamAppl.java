package telran.company.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

import telran.company.model.Employee;
import telran.company.model.SalesManager;

public class CompanyStreamAppl implements Company {
	String name;
	Set<Employee> employees;
	int capacity;

	public CompanyStreamAppl(int capacity) {
		this.capacity = capacity;
		employees = new HashSet<>();
	}

	//
	@Override
	public boolean addEmployee(Employee employee) {
		if (employee == null || capacity == employees.size() || findEmployee(employee.getId()) != null) {
			return false;
		}
		return employees.add(employee);

	}

//
	@Override
	public Employee removeEmployee(int id) {
		Employee victim = findEmployee(id);
		employees.remove(victim);
		return victim;
	}

//
	@Override
	public Employee findEmployee(int id) {
		return employees.stream()
									.filter(e -> e.getId() == id)
									.findFirst()
									.orElse(null);
	}

//
	@Override
	public double totalSalary() {
		double sum = 0;
		return employees.stream()
									.map(e->e.calcSalary())
									.reduce(0.0, (acc, salary) -> acc + salary);
									
									}

// 
	@Override
	public double averageSalary() {
		return totalSalary() / employees.size();
	}

	@Override
	public double totalSales() {

		return employees.stream()
									.filter(e -> e instanceof SalesManager)
									.map(e-> (SalesManager)e)
									.map(SalesManager::getSalesValue)
									.reduce(0., (a,b)-> a+b);
	}

	@Override
	public int size() {
		return employees.size();
	}

	@Override
	public void printEmployees() {

		employees.forEach(System.out:: println);

	}

	@Override
	public Employee[] findEmployeesHoursGreateThan(int hours) {
		return findEmployeesByPredicate(e -> e.getHours() >= hours);
	}

	@Override
	public Employee[] findEmployeesSalaryBetween(double min, double max) {

		return findEmployeesByPredicate(t -> t.calcSalary() >= min && t.calcSalary() < max);
	}

	private Employee[] findEmployeesByPredicate(Predicate<Employee> predicate) {
/
		return employees.stream()
									.filter(predicate)
									.sorted((o1,o2) -> Integer.compare(o1.getId(), o2.getId()))
									.toArray(Employee[]::new);
	}

}
