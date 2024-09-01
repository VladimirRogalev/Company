package telran.company.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.company.dao.Company;
import telran.company.dao.CompanyImpl;
import telran.company.model.Employee;
import telran.company.model.Manager;
import telran.company.model.SalesManager;
import telran.company.model.WageEmployee;

class CompanyTest {
	Company company;
	Employee[] firm;

	@BeforeEach
	void setUp() throws Exception {
		company = new CompanyImpl(5);
		firm = new Employee[4];
		firm[0] = new Manager(1000, "John", "Smith", 182, 20000, 2);
		firm[1] = new WageEmployee(2000, "Mary", "Smith", 182, 40);
		firm[2] = new SalesManager(1001, "Fredy", "Levvi", 182, 25000, 0.1);
		firm[3] = new SalesManager(12478, "Levvi", "Strauss", 91, 80000, 0.5);
		for (int i = 0; i < firm.length; i++) {
			company.addEmployee(firm[i]);
		}

	}

	@Test
	void testAddEmployee() {
		assertFalse(company.addEmployee(firm[3]));
		Employee employee = new SalesManager(5000, "Sergey", "Ivanov", 182, 160000, 0.2);
		assertTrue(company.addEmployee(employee));
		assertEquals(5, company.size());
		employee = new SalesManager(6000, "Sergey", "Ivanov", 182, 160000, 0.2);
		assertFalse(company.addEmployee(employee));
	}

	@Test
	void testRemoveEmployee() {
		Employee employee = company.removeEmployee(1001);
		assertEquals(3, company.size());
		assertEquals(firm[2], employee);
		assertNull(company.removeEmployee(1001));

	}

	@Test
	void testFindEmployee() {
		assertEquals(firm[2], company.findEmployee(1001));
		assertNull(company.findEmployee(5000));

	}

	@Test
	void testTotalSalary() {
		assertEquals(63104.0, company.totalSalary());
	}

	@Test
	void testAverageSalary() {
		assertEquals(63104.0 / 4, company.averageSalary());
	}

	@Test
	void testTotalSales() {
		assertEquals(105000.0, company.totalSales());
	}

	@Test
	void testSize() {
		assertEquals(4, company.size());
	}

	@Test
	void testPrintEmployees() {
		company.printEmployees();
	}

}
