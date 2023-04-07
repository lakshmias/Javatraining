import static java.lang.Math.*;

public class Staticblock {
	
	static int n1;
	int n2;
	
	//Static block1
	static
	{
		System.out.println("from block1");
		n1=50;
	}
	//static block2
	static
	{
		System.out.println("from Block2");
		n1=100;
	}
	
	{
		System.out.println();
		n2=201;
	}
	
	public static void main(String[] args)
	{
		System.out.println(n1);
		Staticblock sb = new Staticblock();
		System.out.println(sb.n2);
	}
}
