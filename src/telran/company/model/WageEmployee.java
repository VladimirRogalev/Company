package telran.company.model;

public class WageEmployee extends Employee {
	private double wage;

	public WageEmployee(int id, String firstName, String lastName, double hours, double wage) {
		super(id, firstName, lastName, hours);
		this.wage = wage;
	}

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}

	@Override
	public double calcSalary() {
<<<<<<< HEAD
		return checkMinSalary(hours * wage);
=======
		return checkMinSalary(wage * hours);
>>>>>>> b9d2006fe7740045c9c1f11efdaea6e3aec6e9a7
	}

}
