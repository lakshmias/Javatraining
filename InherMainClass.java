 class Emp{
	int empid; 
	String empname = "Devi";

	//final 
	int y = 100;
	
	public Emp() {
		System.out.println("from employee default construtor"+ y++);
	}
	 public Emp(int empid) {
		  
		// when we want to pass the values constructor of the same class. It is called constructor chaining. 
		//Super method and this method cannot be called together.
		//Contructor should be the first statement in the method
		
		this("Hello");  
		this.empid=empid;
		System.out.println("from employee parametrized constructor");
	}
	
	public Emp(String str) {
		System.out.println("from employee overloaded const " + str);
	}
	
	public String getDetails() {
		return empid+ "-----" +empname;
	}

	public void viewsalary()
	{
		System.out.println("view salary from parent class");
	}
}

class Manager extends Emp{
	String dept = "IT";
	
	public Manager() {
		super(500); //used to invoke the base class constructor
		System.out.println("from mgr child contructor");
	}

	public String getDetails() {  //Overridden 
		return super.getDetails()+ "----" + dept;  //super keyword to ivoke the base class overridden method
	}
	
	public void assignproject()
	{
		System.out.println("assign project from Child class");
	}
}

class salary{
	
}

public class InherMainClass {

	public static void main(String args[])
	{
		Emp emp = new Emp();
		//System.out.println(em.getDetails());
		
		//Manager mgr = new Manager();
		//System.out.println(mgr.getDetails());
		
		Emp em = new Manager();
		System.out.println(em.getDetails());
		em.viewsalary();
		
		if(emp instanceof Emp)
		{
			System.out.println("you are manager");
		}
		else {
			System.out.println("You are emp");
		}
			
		
	}
	
}
