package telran.company.dao;

import telran.company.model.Employee;

public interface Company {
	boolean addEmployee(Employee employee);

	Employee removeEmployee(int id);

	Employee findEmployee(int id);

	double totalSalary();

	double averageSalary();

	double totalSales();

	int size();
	
	Employee [] findEmployeeysHoursGreatThan(int hours);
	Employee [] findEmployeeysSalaryBetween(double min, double max);

	void printEmployees();

}
