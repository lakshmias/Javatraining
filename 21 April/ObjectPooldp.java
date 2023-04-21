import java.util.HashSet;
import java.util.Set;
class Employee {
    private int id;
    private String name;
    private String email;

    public Employee() {
        // default constructor
    }

    public Employee(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


class EmployeePool {
    private static EmployeePool instance;
    private Set<Employee> employees;
    private int poolSize;

    private EmployeePool() {
        employees = new HashSet<>();
        poolSize = 3;
    }

    public static synchronized EmployeePool getInstance() {
        if (instance == null) {
            instance = new EmployeePool();
        }
        return instance;
    }

    public synchronized Employee acquire() {
        if (employees.isEmpty()) {
            return new Employee();
        }
        Employee e = employees.iterator().next();
        employees.remove(e);
        return e;
    }

    public synchronized void release(Employee e) {
        if (employees.size() < poolSize) {
            employees.add(e);
        }
    }
}

public class ObjectPooldp{
	public static void main(String[] args) {
	    EmployeePool pool = EmployeePool.getInstance();

	    // Acquire three employees from the pool
	    Employee e1 = pool.acquire();
	    Employee e2 = pool.acquire();
	    Employee e3 = pool.acquire();

	    // Release two employees back into the pool
	    pool.release(e1);
	    pool.release(e2);

	    // Acquire two more employees from the pool
	    Employee e4 = pool.acquire();
	    Employee e5 = pool.acquire();
	    Employee e6 = pool.acquire();
	    Employee e7 = pool.acquire();

	    // e1 and e2 should be the same object as before
	    System.out.println(e1 == e4); // true
	    System.out.println(e2 == e5); // true
	    
	    System.out.println(e1);
	    System.out.println(e2);
	    System.out.println(e3);
	    System.out.println(e4);
	    System.out.println(e5);
	    System.out.println(e6);
	    System.out.println(e7);
	}

}

/*

 The Object Pool design pattern can be useful in situations where the creation of a new object 
 is a time-consuming process or requires a lot of resources. By keeping a pool of pre-created objects, 
 we can reuse these objects instead of creating new ones every time they are needed.

One real-time use case for the Object Pool design pattern is in database connections.
 Establishing a new database connection can be a time-consuming and resource-intensive operation, 
 especially if the application needs to create a new connection every time it needs to execute a query. 
 By using an object pool to manage a set of pre-established database connections, 
 the application can reuse existing connections instead of creating new ones each time 
 a query needs to be executed. This can improve performance and reduce resource usage.

Another example of where the Object Pool design pattern could be used is in a web server that 
needs to handle multiple requests concurrently. Instead of creating a new object 
to handle each request, 
a pool of pre-created objects could be used to handle incoming requests. 
This can reduce the overhead associated with object creation and improve the 
server's overall performance.




what is the standard pool size in real time w.r.t db and webserver?
The ideal pool size for a database or web server can vary depending on the specific requirements 
and resources available. There is no one-size-fits-all answer to this question 
as it can depend on 
factors such as the number of concurrent connections or requests, 
the available system resources, 
and the expected usage patterns.

For database connections, the ideal pool size can depend on the number of concurrent requests and 
the number of available database connections. A good starting point can be to use a pool size that 
is slightly larger than the number of concurrent requests, but not so large that it uses up all 
available resources on the system.

For web servers, the ideal pool size can depend on factors such as the number of concurrent requests, 
the server hardware, and the nature of the application being served. A good starting point can be to 
use a pool size that is large enough to handle the expected load without overloading the system.

It is important to monitor the performance of the system and adjust the pool size as needed to ensure
 optimal performance. This can involve testing different pool sizes and monitoring system resource usage 
 to find the optimal configuration for a specific application.



 */
