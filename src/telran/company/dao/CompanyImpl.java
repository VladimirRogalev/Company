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

<<<<<<< HEAD
=======
//O(n)
>>>>>>> b9d2006fe7740045c9c1f11efdaea6e3aec6e9a7
	@Override
	public boolean addEmployee(Employee employee) {
		if (employee == null || size == employees.length || findEmployee(employee.getId()) != null) {
			return false;
		}
		employees[size] = employee;
		size++;
		return true;
	}
<<<<<<< HEAD

=======
//O(n)
>>>>>>> b9d2006fe7740045c9c1f11efdaea6e3aec6e9a7
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

<<<<<<< HEAD
=======
// O(n)
>>>>>>> b9d2006fe7740045c9c1f11efdaea6e3aec6e9a7
	@Override
	public Employee findEmployee(int id) {
		for (int i = 0; i < size; i++) {
			if (employees[i].getId() == id) {
				return employees[i];
			}
		}
		return null;
	}
<<<<<<< HEAD

	@Override
	public double totalSalary() {
		double sum = 0;
		for (int i = 0; i < size; i++) {
			sum += employees[i].calcSalary();
		}
		return sum;
	}
=======
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
>>>>>>> b9d2006fe7740045c9c1f11efdaea6e3aec6e9a7

	@Override
	public double averageSalary() {
		return totalSalary() / size;
	}
<<<<<<< HEAD

	@Override
	public double totalSales() {
		double sum = 0;

		for (int i = 0; i < size; i++) {
			if (employees[i] instanceof SalesManager) {
//				SalesManager sm = (SalesManager) employees[i];
//				sum+= sm.getSalesValue();
				sum += ((SalesManager) employees[i]).getSalesValue();
			}
		}

		return sum;
	}

=======
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
>>>>>>> b9d2006fe7740045c9c1f11efdaea6e3aec6e9a7
	@Override
	public int size() {
		return size;
	}
<<<<<<< HEAD

=======
//O(n)
>>>>>>> b9d2006fe7740045c9c1f11efdaea6e3aec6e9a7
	@Override
	public void printEmployees() {
		for (int i = 0; i < size; i++) {
			System.out.println(employees[i]);
<<<<<<< HEAD
=======

>>>>>>> b9d2006fe7740045c9c1f11efdaea6e3aec6e9a7
		}

	}

<<<<<<< HEAD
	@Override
	public Employee[] findEmployeesHoursGreateThan(int hours) {
		return findEmployeesByPredicate(e -> e.getHours() >= hours);
	}

	@Override
	public Employee[] findEmployeesSalaryBetween(double min, double max) {
//		Predicate<Employee> predicate = new Predicate<Employee>() {
//
//			@Override
//			public boolean test(Employee t) {
//				return t.calcSalary() >= min && t.calcSalary() < max;
//			}
//		};
		return findEmployeesByPredicate(t -> t.calcSalary() >= min && t.calcSalary() < max);
	}

	private Employee[] findEmployeesByPredicate(Predicate<Employee> predicate) {
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (predicate.test(employees[i])) {
				count++;
			}
		}
		Employee[] res = new Employee[count];
		for (int i = 0, j = 0; j < res.length; i++) {
			if (predicate.test(employees[i])) {
				res[j++] = employees[i];
			}
		}
=======
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

>>>>>>> b9d2006fe7740045c9c1f11efdaea6e3aec6e9a7
		return res;
	}

}
