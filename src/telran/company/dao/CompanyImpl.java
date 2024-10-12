package telran.company.dao;

import java.util.function.Predicate;

import telran.company.model.Employee;
import telran.company.model.SalesManager;

public class CompanyImpl implements Company {
	String name;
	Employee[] employees;
	int size;

	public CompanyImpl(int capacity) {
		employees = new Employee[capacity];
	}

//O(n)
	@Override
	public boolean addEmployee(Employee employee) {
		if (employee == null || size == employees.length || findEmployee(employee.getId()) != null) {
			return false;
		}
		employees[size] = employee;
		size++;
		return true;
	}
//O(n)
	@Override
	public Employee removeEmployee(int id) {
		for (int i = 0; i < size; i++) {
			if (employees[i].getId() == id) {
				Employee victim = employees[i];
				employees[i] = employees[size - 1];
				employees[size - 1] = null;
				size--;
				return victim;
			}
		}
		return null;
	}

// O(n)
	@Override
	public Employee findEmployee(int id) {
		for (int i = 0; i < size; i++) {
			if (employees[i].getId() == id) {
				return employees[i];
			}
		}
		return null;
	}
//O(n)
	@Override
	public double totalSalary() {
		double sum = 0;

		for (int i = 0; i < size; i++) {
			sum += employees[i].calcSalary();
		}

		return sum;
	}
	//O(n)

	@Override
	public double averageSalary() {
		return totalSalary() / size;
	}
//O(n)
	@Override
	public double totalSales() {
		double sum = 0;
		for (int i = 0; i < size; i++) {
			if (employees[i] instanceof SalesManager) {
//			SalesManager sm = (SalesManager)employees[i];
//			sum += sm.getSalesValue();
				sum += ((SalesManager) employees[i]).getSalesValue();

			}
		}
		return sum;
	}
// O(n)
	@Override
	public Employee[] findEmployeeysHoursGreatThan(int hours) {
		Predicate<Employee> predicateForHours = new Predicate<Employee>() {

			@Override
			public boolean test(Employee t) {

				return t.getHours() > hours;
			}
		};

		return findEmployeesByPredicate(predicateForHours);
	}
	
	//O(n)

	@Override
	public Employee[] findEmployeeysSalaryBetween(double min, double max) {
		Predicate<Employee> predicateForSalaryBetween = new Predicate<Employee>() {

			@Override
			public boolean test(Employee t) {
				// TODO Auto-generated method stub
				return t.calcSalary() >= min && t.calcSalary() < max;
			}
		};
		return findEmployeesByPredicate(predicateForSalaryBetween);
	}
//O(1)
	@Override
	public int size() {
		return size;
	}
//O(n)
	@Override
	public void printEmployees() {
		for (int i = 0; i < size; i++) {
			System.out.println(employees[i]);

		}

	}

	private Employee[] findEmployeesByPredicate(Predicate<Employee> predicate) {
		Employee[] res;
		int counter = 0;
		for (int i = 0; i < size; i++) {
			if (predicate.test(employees[i])) {
				counter++;
			}

		}
		res = new Employee[counter];
		int j = 0;
		for (int i = 0; i < size; i++) {
			if (predicate.test(employees[i])) {
				res[j++] = employees[i];

			}

		}

		return res;
	}

}
