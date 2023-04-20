class Singleton{
private static Singleton instance = null;
    
    private String message; // Example variable
    
    private Singleton() {
        // Private constructor to prevent instantiation from outside the class
    }
    
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
	
}

public class singletonDP {

	public static void main(String[] args) {
		
		Singleton singleton = Singleton.getInstance();
		singleton.setMessage("Hello, World!");

		System.out.println(singleton.getMessage()); // Output: "Hello, World!"
		
		//To prove that it is the single instance
		System.out.println(singleton);
		Singleton singleton1 = Singleton.getInstance();
		System.out.println(singleton1);
	}

}
