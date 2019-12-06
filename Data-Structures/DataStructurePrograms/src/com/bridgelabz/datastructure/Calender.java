
package com.bridgelabz.datastructure;

import java.util.Calendar;

import com.bridgelabz.utility.datastructure.Utility;

/**
 * @author Premsai Manthani
 * @purpose : this program perform the calender and display the monthly calender
 *          on the screen.
 * 
 */
public class Calender {

	public static void main(String[] args) {
		Utility u1 = new Utility();
		int month = Integer.parseInt(args[0]); // month (Jan = 1 to Dec = 12)
		int year = Integer.parseInt(args[1]); // year

		// months[i] = name of month i
		String[] months = { "", // leave empty so that months[1] = "January"
				"January", "February", "March", "April", "May", "June", "July", "August", "September", "October",
				"November", "December" };

		// days[i] = number of days in month i
		int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		// check for leap year
		if (month == 2 && u1.isLeapYear(year))
			days[month] = 29;

		// print calendar header
		System.out.println("   " + months[month] + " " + year);
		System.out.println(" S  M Tu  W Th  F  S");

		// starting day
		int d = u1.day(month, 1, year);// Function call for return staring day of month

		// print the calendar
		for (int i = 0; i < d; i++)
			System.out.print("   ");
		for (int i = 1; i <= days[month]; i++) {
			System.out.printf("%2d ", i);
			if (((i + d) % 7 == 0) || (i == days[month]))
				System.out.println();
		}

	}
}
