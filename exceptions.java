package com.Inheritance;

import java.io.*;


public class exceptions {

	public static void main(String[] args)
	{
		try {
		int x=0;int y = 0;int z = 0;

		InputStreamReader ISR = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ISR);

		System.out.println("Enter x:");
		x = Integer.parseInt(br.readLine());
		
		System.out.println("Enter y:");
		y = Integer.parseInt(br.readLine());
		z=x+y;
		System.out.println("Z : " +z);
		}
		catch(Exception ex){
			System.out.println("except");
		}
		finally {
			System.out.println("finally");
		}
	}
	
}
