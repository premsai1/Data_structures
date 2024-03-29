package com.bridgelabz.datastructure;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.bridgelabz.utility.datastructure.Utility;

/**
 * @author Premsai Manthani
 * @purpose : this performewd the ordered list and inserts the data in the in
 *          the linked list.
 * 
 */
public class OrderList {
	public static void main(String[] args) throws IOException {

		Utility u1 = new Utility();
		LinkedList<Integer> list = new LinkedList<Integer>();

		File f1 = new File("/home/admin1/Desktop/File/OrderList.txt"); // Creation of File Descriptor for // input file
		FileReader fr = new FileReader(f1); // Creation of File Reader object
		BufferedReader br = new BufferedReader(fr); // Creation of BufferedReader object

		String str = "";
		String[] arr1 = null;
		while ((str = br.readLine()) != null) // Reading Content from the file
		{
			arr1 = str.split(" ");
			int[] arr2 = new int[arr1.length];
			System.out.println("data from file is:");
			for (int i = 0; i < arr1.length; i++) {
				arr2[i] = Integer.parseInt(arr1[i]);
				System.out.print(arr1[i] + " "); // data from file
				list.insertAtPosition(i, arr2[i]); // insert data in asending oder
			}
		}
		list.sort(list);
		System.out.println("\nsorted linked list from data is");
		list.printList();

		try {
			System.out.println("\nsearch the element:");
			int item = u1.inputNumber();

			if (list.search(item)) {
				list.DeleteAtPosition(item - 1);
			} else {
				list.insertAtSpecificPosition(item);
			}

			String s = "";
			int n = list.getListSize() + 1;
			int[] arr = new int[n];
			Node<Integer> temp = list.start;
			for (int i = 0; i < n; i++) {
				arr[i] = temp.getData();
				temp = temp.getNext();
				s = s + arr[i] + " ";
			}
			System.out.println("after searching operation list is");
			list.printList();
			FileWriter fw = new FileWriter("/home/admin1/Desktop/File/OrderListAns.txt");
			fw.write(s);
			fw.flush();
			fw.close();
		} catch (Exception e) {
			System.out.println("enter valid input");
		}
	}
}
