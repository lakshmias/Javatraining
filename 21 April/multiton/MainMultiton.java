import java.util.HashMap;
import java.util.Map;

public class MainMultiton {

	public static void main(String[] args) {
		EmployeeMultiton employee1 = EmployeeMultiton.getInstance("1", "John", 12345);
		EmployeeMultiton employee2 = EmployeeMultiton.getInstance("2", "James", 54321);
		EmployeeMultiton employee3 = EmployeeMultiton.getInstance("1", "Julie", 67890);

		employee1.displayInfo(); // output: Name: John, ID: 12345
		employee2.displayInfo(); // output: Name: James, ID: 54321
		employee3.displayInfo(); // output: Name: Julie, ID: 12345
	}

}


/*
In this example, we create three instances of the EmployeeMultiton class
 with two instances sharing the same key "1". 
 When we call the displayInfo() method on employee1, employee2, and employee3, 
we see that employee1 and employee3 have the same name and id values, indicating that they are the same instance.

what is the difference between multiton and singleton
The main difference between Multiton and Singleton design patterns is that Multiton pattern creates
 multiple instances of a class with a finite and pre-defined number of possible instances, 
while Singleton pattern creates only one instance of a class throughout the entire lifetime of the application.

In a Multiton pattern, you have a limited number of instances, each identified by a key or name.
 The instances are usually created when they are first requested and cached for future use. 
 This pattern can be useful in cases where you need to manage a finite number of shared resources, 
 such as database connections or thread pools.

On the other hand, a Singleton pattern ensures that there is only one instance of a class in the
 entire application, which can be accessed globally. This pattern is commonly used for managing resources 
 that must be shared across the entire application and should not be replicated, such as a configuration manager
  or a logger.

In summary, while Singleton pattern ensures that there is only one instance of a class in the application, 
Multiton pattern creates a finite and predefined number of instances, each identified by a key or name.
*/
class EmployeeMultiton {
    private static Map<String, EmployeeMultiton> instances = new HashMap<>();
    private String name;
    private int id;
    
    private EmployeeMultiton(String name, int id) {
        this.name = name;
        this.id = id;
    }
    
    public static synchronized EmployeeMultiton getInstance(String key, String name, int id) {
        if (!instances.containsKey(key)) {
            instances.put(key, new EmployeeMultiton(name, id));
        }
        return instances.get(key);
    }
    
    public void displayInfo() {
        System.out.println("Name: " + name + ", ID: " + id);
    }
}

//Singleton
class ResourceSingleton {
	private static Resource instance = new Resource();

	private ResourceSingleton() {
	}

	public static Resource getInstance() {
		return instance;
	}
}

//Multiton
class ResourceMultiton {
	private static Map<String, Resource> instances = new HashMap<>();

	private ResourceMultiton() {
	}

	public static synchronized Resource getInstance(String key) {
		if (!instances.containsKey(key)) {
			instances.put(key, new Resource());
		}
		return instances.get(key);
	}
}

class ResourceMultitonn {
	private static Map<String, Resource> minstances = new HashMap<>();
	private static final int MAX_INSTANCES = 3;

	private ResourceMultitonn() {
	}

	public static Resource getInstance(String key) {
		if (!minstances.containsKey(key) && minstances.size() < MAX_INSTANCES) {
			minstances.put(key, new Resource());
		}
		return minstances.get(key);
	}
}

class Resource {
	private String name;

	public Resource() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Resource(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

class MultiNSingle {
	public static void main(String[] args) {
		// Singleton
		Resource r1 = ResourceSingleton.getInstance();
		Resource r2 = ResourceSingleton.getInstance();
		System.out.println(r1 == r2); // true

		System.out.println("-------------");
		// Multiton
		Resource r3 = ResourceMultiton.getInstance("key1");
		Resource r4 = ResourceMultiton.getInstance("key1");
		Resource r5 = ResourceMultiton.getInstance("key2");
		System.out.println(r3 == r4); // true
		System.out.println(r4 == r5); // false
		
		System.out.println("-------------");
		//ResourceMultitonn with fixed no of keys
		Resource res1 = ResourceMultitonn.getInstance("key1");
		Resource res2 = ResourceMultitonn.getInstance("key1");
		Resource res3 = ResourceMultitonn.getInstance("key3");
		Resource res4 = ResourceMultitonn.getInstance("key4");

		System.out.println(res1 == res2); // true
		System.out.println(res2 == res3); // false
		System.out.println(res3 == res4); // false
	}
}