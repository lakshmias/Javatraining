import java.util.*;

//Define the Employee class
class Employee {
 private String name;
 private int id;
 
 public Employee(String name, int id) {
     this.name = name;
     this.id = id;
 }
 
 public String getName() {
     return name;
 }
 
 public int getId() {
     return id;
 }
}

//Define the expression interface
interface Expression {
 boolean interpret(Employee employee);
}

//Define the OrExpression class that implements the Expression interface
class OrExpression implements Expression {
 private Expression expression1;
 private Expression expression2;
 
 public OrExpression(Expression expression1, Expression expression2) {
     this.expression1 = expression1;
     this.expression2 = expression2;
 }
 
 public boolean interpret(Employee employee) {
     return expression1.interpret(employee) || expression2.interpret(employee);
 }
}

//Define the AndExpression class that implements the Expression interface
class AndExpression implements Expression {
 private Expression expression1;
 private Expression expression2;
 
 public AndExpression(Expression expression1, Expression expression2) {
     this.expression1 = expression1;
     this.expression2 = expression2;
 }
 
 public boolean interpret(Employee employee) {
     return expression1.interpret(employee) && expression2.interpret(employee);
 }
}

//Define the NameExpression class that implements the Expression interface
class NameExpression implements Expression {
 private String name;
 
 public NameExpression(String name) {
     this.name = name;
 }
 
 public boolean interpret(Employee employee) {
     return employee.getName().equalsIgnoreCase(name);
 }
}

//Define the IdExpression class that implements the Expression interface
class IdExpression implements Expression {
 private int id;
 
 public IdExpression(int id) {
     this.id = id;
 }
 
 public boolean interpret(Employee employee) {
     return employee.getId() == id;
 }
}

//Main class to test the implementation
public class InterpreterExample {
 public static void main(String[] args) {
     List<Employee> employees = new ArrayList<Employee>();
     employees.add(new Employee("John", 1));
     employees.add(new Employee("Jane", 2));
     employees.add(new Employee("Bob", 3));
     
     Expression expression1 = new NameExpression("John");
     Expression expression2 = new IdExpression(2);
     Expression orExpression = new OrExpression(expression1, expression2);
     
     System.out.println("Employees who match the expression: " + orExpression.interpret(employees.get(0)) + ", " + orExpression.interpret(employees.get(1)) + ", " + orExpression.interpret(employees.get(2)));
     
     Expression expression3 = new NameExpression("Bob");
     Expression expression4 = new IdExpression(3);
     Expression andExpression = new AndExpression(expression3, expression4);
     
     System.out.println("Employee who matches the expression: " + andExpression.interpret(employees.get(0)) + ", " + andExpression.interpret(employees.get(1)) + ", " + andExpression.interpret(employees.get(2)));
 }
}