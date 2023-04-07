class threadOne extends Thread
{
    public void run()
    {
        System.out.println("method starts");
        try
        {
            for(int i=1;i<5;i++)
        {
            Thread.sleep(1000);
            System.out.println(i);
        }
        }
        catch(InterruptedException iex)
        {
            System.out.println("inside exception : " +iex.getMessage());
        }
        
        System.out.println("method stops");
    }
}

class threadTwo implements Runnable
{
    public void run()
    {
        System.out.println("method starts");
        try
        {
            for(int i=1;i<5;i++)
        {
            Thread.sleep(1000);
            System.out.println(i);
        }
        }
        catch(InterruptedException iex)
        {
            System.out.println("inside exception : " +iex.getMessage());
        }
        
        System.out.println("method stops");
    }
}
public class threadExample {
    public static void main(String[] args) {
        System.out.println("Main starts");
        threadOne oThreadOne=new threadOne();
        oThreadOne.start();

        threadTwo oThreadTwo=new Thread(oThreadOne);
        oThreadTwo.start();
        System.out.println("main closes");
    }
}
