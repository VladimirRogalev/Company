package telran.company.dao;

import java.util.Iterator;

import telran.company.model.Employee;

public class CompanyImpl implements Company {
	String name;
	Employee[] employees;
	int size;

	public CompanyImpl(int capacity) {
		employees = new Employee[capacity];
	}

	@Override
	public boolean addEmployee(Employee employee) {
		for (int i = 0; i < size; i++) {
			if (employees[i].getId() == employee.getId()) {
				return false;
			}

		}
		if (employees.length == size) {
			return false;
		}
		employees[size] = employee;
		size++;
		return true;
	}

	@Override
	public Employee removeEmployee(int id) {
		// TODO Auto-generated method stub
		size--;
		return null;
	}

	@Override
	public Employee findEmployee(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double totalSalary() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double averageSalary() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double totalSales() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void printEmployees() {
		// TODO Auto-generated method stub

	}

}
