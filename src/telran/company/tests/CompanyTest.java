package telran.company.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.company.dao.Company;
<<<<<<< HEAD
import telran.company.dao.CompanyListImpl;
import telran.company.dao.CompanySetImpl;
=======
import telran.company.dao.CompanyImpl;
>>>>>>> b9d2006fe7740045c9c1f11efdaea6e3aec6e9a7
import telran.company.model.Employee;
import telran.company.model.Manager;
import telran.company.model.SalesManager;
import telran.company.model.WageEmployee;

class CompanyTest {
	Company company;
	Employee[] firm;

	@BeforeEach
	void setUp() throws Exception {
<<<<<<< HEAD
		company = new CompanySetImpl(5);
		firm = new Employee[4];
		firm[0] = new Manager(1000, "John", "Smith", 182, 20_000, 2);
		firm[1] = new WageEmployee(2000, "Mary", "Smith", 182, 40);
		firm[2] = new SalesManager(3000, "Peter", "Jackson", 182, 40_000, 0.1);
		firm[3] = new SalesManager(4000, "Tigran", "Petrosian", 91, 80_000, 0.1);
		for (int i = 0; i < firm.length; i++) {
			company.addEmployee(firm[i]);
		}
=======
		company = new CompanyImpl(5);
		firm = new Employee[4];
		firm[0] = new Manager(1000, "John", "Smith", 182, 20000, 2);
		firm[1] = new WageEmployee(2000, "Mary", "Smith", 182, 40);
		firm[2] = new SalesManager(1001, "Fredy", "Levvi", 182, 25000, 0.1);
		firm[3] = new SalesManager(12478, "Levvi", "Strauss", 91, 80000, 0.5);
		for (int i = 0; i < firm.length; i++) {
			company.addEmployee(firm[i]);
		}

>>>>>>> b9d2006fe7740045c9c1f11efdaea6e3aec6e9a7
	}

	@Test
	void testAddEmployee() {
		assertFalse(company.addEmployee(firm[3]));
<<<<<<< HEAD
		Employee employee = new SalesManager(5000, "Sergey", "Petrov", 182, 160_000, 0.2);
		assertTrue(company.addEmployee(employee));
		assertEquals(5, company.size());
		employee = new SalesManager(6000, "Sergey", "Petrov", 182, 160_000, 0.2);
=======
		Employee employee = new SalesManager(5000, "Sergey", "Ivanov", 182, 160000, 0.2);
		assertTrue(company.addEmployee(employee));
		assertEquals(5, company.size());
		employee = new SalesManager(6000, "Sergey", "Ivanov", 182, 160000, 0.2);
>>>>>>> b9d2006fe7740045c9c1f11efdaea6e3aec6e9a7
		assertFalse(company.addEmployee(employee));
	}

	@Test
	void testRemoveEmployee() {
<<<<<<< HEAD
		assertEquals(firm[2], company.removeEmployee(3000));
		assertEquals(3, company.size());
//		Employee employee = company.removeEmployee(3000);
//		assertEquals(firm[2], employee);
//		assertEquals(3, company.size());

		assertNull(company.removeEmployee(3000));
=======
		Employee employee = company.removeEmployee(1001);
		assertEquals(3, company.size());
		assertEquals(firm[2], employee);
		assertNull(company.removeEmployee(1001));

>>>>>>> b9d2006fe7740045c9c1f11efdaea6e3aec6e9a7
	}

	@Test
	void testFindEmployee() {
<<<<<<< HEAD
		assertEquals(firm[2], company.findEmployee(3000));

		assertNull(company.findEmployee(5000));
=======
		assertEquals(firm[2], company.findEmployee(1001));
		assertNull(company.findEmployee(5000));

>>>>>>> b9d2006fe7740045c9c1f11efdaea6e3aec6e9a7
	}

	@Test
	void testTotalSalary() {
<<<<<<< HEAD
		assertEquals(61104.0, company.totalSalary());
=======
		assertEquals(63104.0, company.totalSalary());
>>>>>>> b9d2006fe7740045c9c1f11efdaea6e3aec6e9a7
	}

	@Test
	void testAverageSalary() {
<<<<<<< HEAD
		assertEquals(61104.0 / 4, company.averageSalary());
=======
		assertEquals(63104.0 / 4, company.averageSalary());
>>>>>>> b9d2006fe7740045c9c1f11efdaea6e3aec6e9a7
	}

	@Test
	void testTotalSales() {
<<<<<<< HEAD
		assertEquals(120_000, company.totalSales());
=======
		assertEquals(105000.0, company.totalSales());
>>>>>>> b9d2006fe7740045c9c1f11efdaea6e3aec6e9a7
	}

	@Test
	void testSize() {
		assertEquals(4, company.size());
	}
<<<<<<< HEAD
=======
	
	@Test 
	void testFindEmployeeysHoursGreatThan () {
		Employee [] expected = {firm [0], firm[1], firm [2]};
		Employee [] actuals = company.findEmployeeysHoursGreatThan(181);
		assertArrayEquals(expected, actuals);;
	
}
	
	@Test 
	void testFindEmployeeysSalaryBetween() {
		Employee [] expected = { firm[0] };
		Employee [] actuals = company.findEmployeeysSalaryBetween(8000, 22000);
		
		assertArrayEquals(expected, actuals);
		
		Employee [] expected1 = {};
		actuals = company.findEmployeeysSalaryBetween(500, 700);
		assertArrayEquals(expected1, actuals);
		
 		
	}
>>>>>>> b9d2006fe7740045c9c1f11efdaea6e3aec6e9a7

	@Test
	void testPrintEmployees() {
		company.printEmployees();
	}

<<<<<<< HEAD
	@Test
	void testFindEmployeesHoursGreateThan() {
		Employee[] actual = company.findEmployeesHoursGreateThan(100);
		Employee[] expected = { firm[0], firm[1], firm[2] };
		assertArrayEquals(expected, actual);
	}

	@Test
	void testFindEmployeesSalaryBetween() {
		Employee[] actual = company.findEmployeesSalaryBetween(5000, 8000);
		Employee[] expected = { firm[1], firm[2] };
		assertArrayEquals(expected, actual);
	}

=======
>>>>>>> b9d2006fe7740045c9c1f11efdaea6e3aec6e9a7
}
