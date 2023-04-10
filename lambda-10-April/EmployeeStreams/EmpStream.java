import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Employee {
	private String fname;
	private String lname;
	private String dept;
	private int salary;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String fname, String lname, String dept, int salary) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.dept = dept;
		this.salary = salary;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [fname=" + fname + ", lname=" + lname + ", dept=" + dept + ", salary=" + salary + "]";
	}

}
 
public class EmpStream 
{

	public static void main(String[] args) {
		Employee[] emparr = {
				new Employee("Sachin","Tendulkar", "IT", 50000),
				new Employee("Amir", "Khan", "HR", 45000),
				new Employee("MS","Dhoni","Sales", 60000),
				new Employee("Virat","Koli","Sales",55000),
				new Employee("Yuvaraj", "Singh", "IT",35000)				
		};
	
		
		List<Employee> empList = Arrays.asList(emparr);
		System.out.println(empList);
		
		boolean  result =empList.stream().anyMatch(emp->emp.getDept().matches("IT"));
		if(result)
		{
			System.out.println("Employees available");
		}
		else
		{
			System.out.println("Employees NOT available");
		}
		
		Predicate<Employee> p1=em ->(em.getSalary() >40000 && em.getSalary()<60000);
		empList.stream()
		.filter(p1)
		.sorted(Comparator.comparing(Employee::getFname))
		.forEach(System.out::println);
		
		
	    System.out.println(empList.stream().filter(p1).findFirst().get());
		
		/*
		IT
		  sac
		  amir
		Sales
		   MSD
		   VK
		 HR
		   Amir*/
	    System.out.println("-----------------------------------------------------------");
	    Map<String,List<Employee>> groupByDept = empList.stream()
	    		.collect(Collectors.groupingBy(Employee::getDept));
		System.out.println(groupByDept);
		
		groupByDept.forEach((dep,empInDept)->
		{
			System.out.println(dep);
			/*Iterator<Employee> i = empInDept.iterator();
			while(i.hasNext()) {
				System.out.println(i.next());
			}*/
			empInDept.forEach(System.out::println);
		});
		
		
	}

}