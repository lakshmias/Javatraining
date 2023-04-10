import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import java.io.IOException;
import java.io.*;
import java.util.Comparator;
import java.util.Scanner;


public class EmployeeController implements EmployeeInterface {

    //View methods
    public static void addViewEmp() throws IOException {
		EmployeeInterface ec = new EmployeeController();
		Scanner sc = new Scanner(System.in);
		String choice = null;
		do {

			System.out.println("Enter your choice");
			System.out.println("1. Add Employee");
			System.out.println("2. View Employee");
			System.out.println("3. Serialize Employee");
			System.out.println("4. DeSerialize Employee");
			System.out.println("5. Sort By Employee ID");
			System.out.println("6. Sort By Employee Name");
			int ch = sc.nextInt();
			switch (ch) {
			case 1: {
				ec.addEmployee();
				break;
			}
			case 2: {
				ec.viewEmployee();
				break;
			}
			case 3: {
				ec.SerialEmp();
				break;
			}
			case 4: {
				ec.DeSerialEmp();
				break;
			}
			case 5: {
				ec.sortByEid();
				break;
			}
			case 6: {
				ec.sortByEname();
				break;
			}
			default: {
				System.out.println("Enter right choice");
				break;
			}
			}
			System.out.println("Do u want to continue Y or y");
			choice = sc.next();
		} while (choice.equals("Y") || choice.equals("y"));
		System.out.println("Exited");
		System.exit(0);

	}
	public static void main(String[] args) throws IOException {

		System.out.println("Welcome");
		String uname = null;
		String pwd = null;
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			System.out.println("Enter user name:");
			uname = br.readLine();
			System.out.println("Enter Password:");
			pwd = br.readLine();
			if (uname.equals("test") && pwd.equals("pass")) {
				System.out.println("Welcome" + uname);
				addViewEmp();
			} else {
				throw new UserNotFoundException("User "+uname+" not found");
			}
		} catch (Exception ex) {
			System.out.println("except"+ex);
			ex.printStackTrace();
			//System.exit(0);
		}

		
	}
	Employee emp;
	List<Employee> emplist = new ArrayList<Employee>();
	
	public void addEmployee()
	{		
		emp = new Employee();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Eid");
		int eid= sc.nextInt();
		emp.setEid(eid);
		
		System.out.println("Enter Ename");
		String ename= sc.next();
		emp.setEname(ename);
		emplist.add(emp);
		System.out.println("Employee Added Succesfully");
	}
	
	public void viewEmployee() {
		//System.out.println(emp);
		Iterator i = emplist.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
	}
	public void SerialEmp() throws IOException {
		try{
			Iterator i = emplist.iterator();
			
			//Employee emp = new Employee();
		
			FileOutputStream fos = new FileOutputStream("dedalus.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(emp);
//			while(i.hasNext()) {
//				oos.writeObject(i.next());
//			}
			System.out.println("Serilized to file dedalus.txt");
			oos.close();
			fos.close();
			}
			catch(FileNotFoundException fnf)
			{
				System.out.println("No file");
			}
		
	}
	public void DeSerialEmp() throws IOException {
		try{
			FileInputStream fis = new FileInputStream("dedalus.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			//System.out.println("inside1 "+(Employee)ois.readObject());
			Employee emp = (Employee)ois.readObject();
			System.out.println(emp);
			System.out.println("DeSerilized from file dedalus.txt");
			System.out.println(emp.getEid());
			System.out.println(emp.getEname());
			ois.close();
			fis.close();
			}
			catch(FileNotFoundException fnf)
			{
				System.out.println("No file");
			}
			catch(ClassNotFoundException cnf)
			{
				System.out.println("No Emp class");
			}
		catch(IOException IO) {
			System.out.println("IO Exception");
		}
	}
	@Override
	public void sortByEid() {
		Collections.sort(emplist);
		System.out.println("After sorting by EID");
		System.out.println(emplist);
	}

	@Override
	public void sortByEname() {
		Collections.sort(emplist, Employee.NameComparator);
		System.out.println(emplist);
		
	}
	
}


interface EmployeeInterface {
	public void addEmployee();
	public void viewEmployee() ;
	public void SerialEmp() throws IOException;
	public void DeSerialEmp() throws IOException;
	public void sortByEid();
	public void sortByEname();
	
}

class Employee implements Serializable,Comparable<Employee> {

	private int eid;
	private String ename;

	 public Employee()
	 {		 
		 System.out.println("From Employee Constructor");
	 }
	 public Employee(int eno,String ename)
	 {		 
		this.eid =eno;
		this.ename = ename;
	 }
	 
	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + "]";
	}
	@Override
	public int compareTo(Employee e) {
		
		return this.eid - e.eid;
	
	}
	
	public static Comparator<Employee> NameComparator = new Comparator<Employee>() {

		@Override
		public int compare(Employee e1, Employee e2) {
			//return e1.getEid() -e2.getEid();
			return e1.getEname().compareTo(e2.getEname());
		}
	
	
	};

}

class UserNotFoundException extends Exception{
	public UserNotFoundException(String msg){
		System.out.println(msg);
		}

}