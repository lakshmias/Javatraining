package bridge;

//Concrete Implementor
public class ContractEmployee implements Employee {
	private String name;
	private int age;
	private double rate;
	private int hours;

	public ContractEmployee(String name, int age, double rate, int hours) {
		this.name = name;
		this.age = age;
		this.rate = rate;
		this.hours = hours;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getAge() {
		return age;
	}

	@Override
	public double getSalary() {
		return rate * hours;
	}

	@Override
	public double getRate() {
		return rate;
	}

	@Override
	public int getHours() {
		return hours;
	}
}
