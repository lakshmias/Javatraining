package lambda;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LambdaEg 
{
    public static void main(String[] args) {
        //Java 7
        // Task task1=new Task();
        // task1.connect();

        // Runnable r=new MyTaskThread();
        // Thread theread =new Thread(r);
        // theread.start();

        //Jav 8
        Thread th1=new Thread(
        ()->{
            Task task=new  Task();
            task.connect();
        }
        );
        th1.start();

        new Thread(new Task()::connect).start();

        System.out.println("users example");
        
        User u1 = new User(11,"Nilima","nilima@gmail.com"); 
        User u2 = new
        User(12,"Praveen","prav@gmail.com"); 
        User u3 = new
        User(13,"Aarika","arika@gmail.com");
        
        
        List<User> li = new ArrayList<User>(); li.add(u1); li.add(u2); li.add(u3);
        System.out.println("User List :" + li);
        
        //option 1
        Iterator<User> i = li.iterator(); while (i.hasNext()) 
        {
        System.out.println(i.next());
        
        }

        //option 2
        li.forEach(lis->System.out.println(lis));

        //option 3
        li.forEach(System.out::println);
    }
}

class MyTaskThread implements Runnable 
{
    @Override
    public void run()
    {
        Task t=new Task();
        t.connect();
    }
}

class Task {
    public void connect()
    {
        System.out.println("inside Connect");
    }
}


class User 
{
	private int uid;
	private String uname;
	private String email;

	public User() {
		super();
		
	}

	public User(int uid, String uname, String email) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.email = email;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", email=" + email + "]";
	}

}
