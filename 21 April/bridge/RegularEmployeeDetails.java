package bridge;

//Refined Abstraction
public class RegularEmployeeDetails implements EmployeeDetails {
 private Employee employee;

 public RegularEmployeeDetails(Employee employee) {
     this.employee = employee;
 }

 @Override
 public void displayDetails() {
     System.out.println("Name: " + employee.getName());
     System.out.println("Age: " + employee.getAge());
     System.out.println("Salary: " + employee.getSalary());
 }
}