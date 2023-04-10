public class volatileClass {

	private final static int numberOfThreads = 3;

	public static void main(String[] args) throws InterruptedException {
		VolatileData volatileData = new VolatileData(); 
		Thread[] threads = new Thread[numberOfThreads]; 
		for (int i = 0; i < numberOfThreads; ++i)
		{
			threads[i] = new VolatileThread(volatileData);
		}
			
		for (int i = 0; i < numberOfThreads; ++i)
		{
			threads[i].start(); 
		}
			
		for (int i = 0; i < numberOfThreads; ++i)
		{
			threads[i].join();
		}
			 
	}
}

class VolatileData   
{  
private volatile int counter = 0;   
public int getCounter()   
{  
return counter;  
}  
public void increaseCounter()   
{  
++counter;      
}  
}  

class VolatileThread extends Thread {
	private final VolatileData data;

	public VolatileThread(VolatileData data) {
		this.data = data;
	}

	@Override
	public void run() {
		int oldValue = data.getCounter();
		System.out.println("Thread " + Thread.currentThread().getId() + ": Before increment = " + oldValue);
		data.increaseCounter();
		int newValue = data.getCounter();
		System.out.println("Thread " + Thread.currentThread().getId() + ": After increment = " + newValue);
	}
}	