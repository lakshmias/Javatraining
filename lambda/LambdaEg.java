package lambda;
import java.util.ArrayList;

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
