import static java.lang.Math.*;

public class array {

	public static void main(String[] args) {
		
		int[]arr = new int[3];
		arr[0]=1;
		arr[1]=2;
		arr[2]=3;
		
		for(int i =0; i<arr.length; i++)
		{
			System.out.println(arr[i]);
		}
		
		for(int i : arr)
		{
			System.out.println(i);
		}

		System.out.println(PI);
	}

}
