package com.dal;

interface Additionn {
	public int add(int a, int b);
	public int sum(int a, int b);
}

public class Java8Sample {

	public static void main(String[] args) {
		//	Func_inter var=()->{}
		Additionn  sum=(a,b)->{
			return a+b;
		};
		System.out.println(sum.add(8, 1));
	}

}
