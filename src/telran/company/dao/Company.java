package telran.company.dao;

import telran.company.model.Employee;

public interface Company {
<<<<<<< HEAD

=======
>>>>>>> b9d2006fe7740045c9c1f11efdaea6e3aec6e9a7
	boolean addEmployee(Employee employee);

	Employee removeEmployee(int id);

	Employee findEmployee(int id);

	double totalSalary();

	double averageSalary();

	double totalSales();

	int size();
<<<<<<< HEAD

	void printEmployees();

	Employee[] findEmployeesHoursGreateThan(int hours);

	Employee[] findEmployeesSalaryBetween(double min, double max);

=======
	
	Employee [] findEmployeeysHoursGreatThan(int hours);
	Employee [] findEmployeeysSalaryBetween(double min, double max);

	void printEmployees();

>>>>>>> b9d2006fe7740045c9c1f11efdaea6e3aec6e9a7
}
