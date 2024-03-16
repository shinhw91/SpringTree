package com.example.test;

/*
 * char - Character
 * byte - Byte
 * int - Integer
 * short
 * long
 * float
 * double
 * boolean
 */

public class 형변환 {
	
	public static void main(String[] args) {
		// other type => String
		Integer score = 100;
		String s = Integer.toString(score);
		System.out.println(s);
		
		double avg = 90.5;
		String a = Double.toString(avg);
		System.out.println(a);
		
		// String => other type
		score = Integer.parseInt(s);
		avg = Double.parseDouble(a);
		System.out.println(score);
		System.out.println(avg);

	}
	
}
