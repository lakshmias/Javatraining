package com.dal;

interface Addition{
	public int add(int a,int b);
}
public class FirstJava8 implements Addition{
	
	@Override
	public int add(int a, int b) {
	
		return a+b;
	}
	public static void main(String[] args) {
		FirstJava8 f = new FirstJava8();
		
		System.out.println(f.add(4, 5));

	}

	
}
