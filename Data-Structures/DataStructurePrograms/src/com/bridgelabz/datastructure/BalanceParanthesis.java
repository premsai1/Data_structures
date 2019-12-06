
package com.bridgelabz.datastructure;

/**
 * @author Premsai Manthani
 * @purpose : this program checks the  whether the given input is a  balanced paraanthesis are not
 * 
 */
import java.util.Scanner;
import java.util.Stack;

import com.bridgelabz.utility.datastructure.Utility;

public class BalanceParanthesis {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Utility u1 = new Utility();
		System.out.println("enter the expression:");
		String str = u1.inputString();// give expression from user.
		u1.simpleBalanceParenthesis(str);// function call.
	}
}
