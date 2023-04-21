package bridge;

//Concrete Implementor
public class RegularEmployee implements Employee {
 private String name;
 private int age;
 private double salary;

 public RegularEmployee(String name, int age, double salary) {
     this.name = name;
     this.age = age;
     this.salary = salary;
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
     return salary;
 }

 @Override
 public double getRate() {
     return 0.0;
 }

 @Override
 public int getHours() {
     return 0;
 }
}
