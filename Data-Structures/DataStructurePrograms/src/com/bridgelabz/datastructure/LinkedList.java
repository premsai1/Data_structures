package com.bridgelabz.datastructure;

/**
 * @author Premsai Manthani
 * @purpose : implements the lined list operations like Add first, Add last ,
 *          Delete first, Delete Llast.
 * 
 */
public class LinkedList<T> {

	public int size;
	public Node<T> start;

	public LinkedList() {
		size = 0;
		start = null;
	}

	public boolean isEmpty() { // isEmpty.
		if (start == null)
			return true;
		else
			return false;
	}

	public int getListSize() { // get list size.
		return size;
	}

	public void printList() { // print list.
		Node<T> temp = start;
		while (temp != null) {
			System.out.print(temp.getData() + " ");
			temp = temp.getNext();
		}
	}

	public void insertAtFirst(T val) {
		Node<T> n = new Node<T>();
		n.setData(val);
		n.setNext(start);
		start = n;
		size++;
	}

	public void insertAtLast(T val) {
		Node<T> n = new Node<T>();
		n.setData(val);
		Node<T> temp = start;
		if (temp == null) {
			start = n;
		} else {
			while (temp.getNext() != null)
				temp = temp.getNext();
			temp.setNext(n);
		}
		size++;
	}

	public void insertAtPosition(int index, T val) {
		if (index == 0)
			insertAtFirst(val);
		else if (index == size + 1)
			insertAtLast(val);
		else if (index > 0 && index <= size) {
			Node<T> n = new Node<T>();
			n.setData(val);
			Node<T> temp = start;
			for (int i = 0; i < index - 1; i++)
				temp = temp.getNext();
			n.setNext(temp.getNext());
			temp.setNext(n);
			size++;
		} else
			System.out.println("insertion not posiible at position" + index);
	}

	public void DeleteFirst() {
		if (start == null)
			System.out.println("list is already empty:");
		else {
			start = start.getNext();
			size--;
		}
	}

	public void DeleteLast() {
		if (start == null)
			System.out.println("list is already empty:");
		else if (size == 1) {
			start = null;
			size--;
		} else {
			Node<T> temp = start;
			for (int i = 1; i < size - 1; i++)
				temp = temp.getNext();
			temp.setNext(null);
			size--;
		}
	}

	public void DeleteAtPosition(int index) {
		if (start == null)
			System.out.println("list is already empty");
		else if (index < 0 || index > size)
			System.out.println("Invalid index");
		else if (index == 0)
			DeleteFirst();
		else if (index == size - 1)
			DeleteLast();
		else {
			Node<T> temp = start;
			for (int i = 0; i < index - 1; i++) {
				temp = temp.getNext();
			}
			Node<T> temp2 = temp.getNext();
			temp.setNext(temp2.getNext());
			size--;
		}
	}

	public static void sort(LinkedList<Integer> list) {
		int temp = 0;
		for (Node<Integer> j = list.start; j != null; j = j.next) {
			for (Node<Integer> j2 = j.next; j2 != null; j2 = j2.next) {
				if (j.data > j2.data) {
					temp = j.data;
					j.data = j2.data;
					j2.data = temp;
				}
			}
		}
	}

	/* Method to add a number at specific position in Linked_List */
	void insertAtSpecificPosition(int num) {
		Node<Integer> n = new Node(new Integer(num));
		if (start == null) {
			start = (Node<T>) n; // List is empty add newNode
			return;
		}

		Node t = start;
		Node move = t.next;

		if (t.next == null && (int) t.data > num) {
			n.next = t;
			start = (Node<T>) n; // If number less than head.data add it first
			return;
		}
		while (t.next != null) {
			// To insert at First
			if (num < (int) t.data) {
				n.next = t;
				start = (Node<T>) n;
				break;
			}
			// To insert at Specific position
			if (num > (int) t.data && num < (int) move.data) {
				n.next = move;
				t.next = n;
				break;
			}
			t = t.next;
			move = move.next;
		}

		if ((int) t.data < num) {
			t.next = n; // To insert at last
		}
	}

	// serach linked list
	boolean search(int word) {
		Node t = start;
		while (t != null) {
			if ((int) t.data == word)
				return true;
			t = t.next;
		}
		return false;
	}
}
