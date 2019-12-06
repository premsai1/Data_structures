
package com.bridgelabz.datastructure;

import java.util.ArrayList;

/**
 * @author Premsai Manthani
 * @purpose : if the no is a primeno and anagaram then it stores in the 2d array
 * 
 */

import com.bridgelabz.utility.datastructure.Utility;

public class PrimeNumberAndAnagram2DArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Utility u1 = new Utility();
		String string1 = "";
		String string2 = "";
		int count = 0;
		// accept the number from user
		System.out.println("Enter the range of the prime number");
		int number = u1.inputNumber();
		// create arraylist and store the prime number in array
		ArrayList<Integer> prime = u1.prime(number);
		int row = prime.size(); // calculate size
		String anagram[][] = new String[row][2];

		System.out.println("\nPrime numbers that are Anagram\n");
		for (int i = 0; i < prime.size(); i++) {
			for (int j = i + 1; j < prime.size(); j++) {
				string1 = Integer.toString(prime.get(i)); // string value convert to Integer and
				string2 = Integer.toString(prime.get(j));
				if (u1.isAnagram(string1, string2)) // check the string is equal or not
				{
					anagram[count][0] = string1;
					anagram[count][1] = string2;
					count++;
				}
			}
		}
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < anagram[0].length; j++) {
				System.out.printf(anagram[i][j] + " "); // display values
			}
			System.out.println();
		}
	}
}
