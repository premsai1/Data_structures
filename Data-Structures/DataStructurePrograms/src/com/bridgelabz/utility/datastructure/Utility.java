package com.bridgelabz.utility.datastructure;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Premsai Manthani
 * @purpose :  this the utility class it contains all the operation.
 * 
 */

public class Utility {

	// scanner.
	static Scanner sc = new Scanner(System.in);

	public static int inputNumber() {
		return sc.nextInt();
	}

	public String inputString() {
		return sc.next();
	}

	public double inputdouble() {
		return sc.nextDouble();
	}

	// 3. Simple Balanced Parenthesis.
	public void simpleBalanceParenthesis(String str) {
		// TODO Auto-generated method stub
		// use stack
		Stack<Integer> stk = new Stack<Integer>();
		int n = str.length();
		for (int i = 0; i < n; i++) {
			char ch = str.charAt(i);
			if (ch == '(')
				stk.push(i);
			else if (ch == ')') {
				try {
					int p = stk.pop() + 1;
					System.out.println("balanced");
				} catch (Exception e) {
					System.out.println("UnBalanced");
				}
			}
		}
		while (!stk.isEmpty())
			System.out.println((stk.pop() + 1) + " unBalaned");
	}

	// 8. Calender
	// return true if the given year is a leap year
	public static boolean isLeapYear(int year) {
		if ((year % 4 == 0) && (year % 100 != 0))
			return true;
		if (year % 400 == 0)
			return true;
		return false;
	}

	public static int day(int month, int day, int year) {
		int y = year - (14 - month) / 12;
		int x = y + y / 4 - y / 100 + y / 400;
		int m = month + 12 * ((14 - month) / 12) - 2;
		int d = (day + x + (31 * m) / 12) % 7;
		return d;
	}

	// 11. 2D Array Prime numbers in 0-1000 range
	// chech here the number is prime or not.
	public static boolean isPrime(int n) {
		int i = 2;
		while (i <= n / 2) {
			if (n % i == 0)
				return false;
			i++;
		}
		return true;
	}

//	cheack prime number
	public static ArrayList<Integer> prime(int number) {
		ArrayList<Integer> prime = new ArrayList<Integer>();

		// This for loop is starts from 2 and iterate n times
		for (int i = 2; i <= number; i++) {
			int c = 0;

			// This for loop is starts from 2 and iterate half of the value of the first
			// loop
			for (int j = 2; j <= i / 2; j++) {

				/*
				 * If the reminder of the first loop value and the second loop value is 0 then
				 * the value of the c is equal to 1 and break the inner loop
				 */
				if (i % j == 0) {
					c = 1;
					break;
				}
			}

			// if c is equal to 0 its mean the value of i is prime number and print the
			// value of i
			if (c == 0)
				prime.add(i);
		}
		return prime;
	}

	// Anagram check for strings

	public static boolean isAnagram(String string1, String string2) {

		// compare the length of two strings is equal or not
		if (string1.length() != string2.length())
			return false;

		// call count method and pass first string
		int count1[] = count(string1);

		// call count method and pass second string
		int count2[] = count(string2);

		// check the value of the two strings are equal or not
		for (int i = 0; i < count1.length; i++) {
			if (count1[i] != count2[i])
				return false;
		}
		return true;
	}

	/**
	 * Purpose: This method is used to count the alphabets present in the string and
	 * increment the index of the count array.
	 * 
	 * @param string
	 * @return integer one dimensional array
	 */
	public static int[] count(String string) {

		// Convert String to character array
		char c[] = string.toCharArray();

		// Define a count array and the size of the array is 36
		int count[] = new int[36];

		// using loop 0 to size of the character array
		for (int i = 0; i < c.length; i++) {

			// if character array is small alphabet
			if (c[i] >= 'a' && c[i] <= 'z')

				// small alphabet covert into the integer and increment the count array
				count[c[i] - 97]++;

			// if character array is capital alphabet
			if (c[i] >= 'A' && c[i] <= 'Z')

				// capital alphabet convert into the integer and increment the count array
				count[c[i] - 65]++;

			// if character array is digit between 0 to 9
			if (c[i] >= '0' && c[i] <= '9')

				// digit convert into the integer and increment the count array
				count[c[i] - 22]++;
		}

		// return count array
		return count;
	}
}
