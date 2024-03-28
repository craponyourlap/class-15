package collections;

import java.util.Scanner;

class Node {
	private int data;
	private Node next;
	
	public Node() {
		this(0, null);
	}
	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
}

class LinkedList{
	private Node head;
	private int size;
	
	public LinkedList() {
		head = null;
		size = 0;
	}
	public boolean isEmpty() {
		if(head == null) {
			return true;
		}
		return false;
	}
	public int getSize() {
		return size;
	}
	//implementation of insertion operation
	//1. insertion at first/head
	public void insertAtFirst(int val) {
		Node n = new Node();
		n.setData(val);
		n.setNext(head);
		head = n;
		size++;
	}
	//2. insertion at the end
	public void insertAtLast(int val) {
		Node n = new Node(), last = head;
		n.setData(val);
		if (head == null) {
			head = n;
		}
		while (last.getNext() != null) {
			last = last.getNext();
		}
		last.setNext(n);
	}
//	this was my original implementation before this guy coded something else different
//	public void insertAtLast(int val) {
//		Node n = new Node(), t = head;
//		n.setData(val);
//		if (t == head) {
//			head = n;
//		}
//		else {
//			while (t.getNext() != null) {
//				t = t.getNext();
//			}
//			t.setNext(n);
//		}
//		size++;
//	}//bro, what is this guy doinggggg?? this looks so much more confusing
	//3. insertion at the position
	public void insertAtPosition(int val, int pos) {
		if (pos == 1) {//we using 1-based indexing? bro what
			insertAtFirst(val);
		}
		else if (pos > 1 && pos <= size) {//lol it's from 1 inclusive to size inclusive
			Node n = new Node(val, null), t = head;
			for (int i = 1; i < pos - 1; i++)t = t.getNext();
			n.setNext(t.getNext());
			t.setNext(n);
			size++;
		}
		else System.out.println("stop trying to do the impossible");
	}
	//implementation of deletion operation
	//4. deletion at first/head
	public void deleteAtFirst() {
		if (isEmpty())System.out.println("shit is empty");
		else {
			head = head.getNext();
			size--;
		}
	}
	//5. deletion at the end
	public void deleteAtLast() {
		if (isEmpty())System.out.println("nothing to delete if it's fucking empty");
		else if (size == 1) {
			head = null;
			size--;
		}
		else {
			Node last = head;
			int ctr = 1;
			while (ctr < size - 1) {
				last = last.getNext();
				ctr++;
			}
			last.setNext(null);
			size--;
		}
	}
	//6. deletion at the position
	public void deleteAtPosition(int pos) {
		if (isEmpty())System.out.println("you know it's empty right?");
		else if (size == 1) {
			head = null;
			size--;
		}
		else if (pos == 1) {
			Node next = head.getNext();
			head = next;
		}
		else if (pos > 1 && pos <= size) {//lol it's from 1 inclusive to size inclusive
			Node t = head, t1;
			for (int i = 1; i < pos - 1; i++)t = t.getNext();
			t1 = t.getNext();// stores the position of node's next address
			t.setNext(t1.getNext());
			size--;
		}
	}
	//7. search for an element
	public int searchItem(int key) {
		Node current = head;
		int pos = 1;
		while (current != null) {
			if (current.getData() == key)
				return pos;
			current = current.getNext();
			pos++;
		}
		return -1;//the method returns here it found nothing (i.e. it doesn't return earlier)
	}
	//8. display the linkedlist
	public void viewLinkedList() {
		Node r;
		if(isEmpty())System.out.println("shit is empty, nothing to print. try alt+f4");
		else {
			r = head;
			for (int i = 1; i <= size; i++) {
				System.out.print(r.getData() + "->");
				r = r.getNext();
			}
		}
		System.out.println();
	}
}

public class LinkedListDemonstration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();
		Scanner in = new Scanner(System.in);
		while(true) {
			int option = 0;
			while(true) {
				try {
					System.out.println("1. insert at head\r\n"
							+ "2. insert at end\r\n"
							+ "3. insert at pos\r\n"
							+ "4. delete at head\r\n"
							+ "5. delete at end\r\n"
							+ "6. delete at pos\r\n"
							+ "7. search for element\r\n"
							+ "8. display linkedlist\r\n"
							+ "9. exit the program");
					System.out.print("enter option: ");
					option = in.nextInt();
					if (option < 1 || option > 9) throw new Exception();
					break;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("dont do that");
					in.nextLine();
				}
			}
			switch(option) {
			case 1:{
				int value;
				while (true) {
					try {
						System.out.println("enter value to insert:");
						value = in.nextInt();
						break;
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println("shit went wrong and its ur fault");
						in.nextLine();
					}
				}
				list.insertAtFirst(value);
			}break;
			case 2:{
				int value;
				while (true) {
					try {
						System.out.println("enter value to insert:");
						value = in.nextInt();
						break;
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println("shit went wrong and its ur fault");
						in.nextLine();
					}
				}
				list.insertAtLast(value);
			}break;
			case 3:{
				int value;
				int pos;
				while (true) {
					try {
						System.out.println("enter value to insert and position:");
						value = in.nextInt();
						pos = in.nextInt();
						break;
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println("shit went wrong and its ur fault");
						in.nextLine();
					}
				}
				list.insertAtPosition(value, pos);
			}break;
			case 4:{
				list.deleteAtFirst();
			}break;
			case 5:{
				list.deleteAtLast();
			}break;
			case 6:{
				int pos;
				while (true) {
					try {
						System.out.println("enter position to delete element:");
						pos = in.nextInt();
						break;
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println("shit went wrong and its ur fault");
						in.nextLine();
					}
				}
				list.deleteAtPosition(pos);
			}break;
			case 7:{
				int key;
				while (true) {
					try {
						System.out.println("enter key to search:");
						key = in.nextInt();
						break;
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println("shit went wrong and its ur fault");
						in.nextLine();
					}
				}
				list.searchItem(key);
			}
			case 8:{
				list.viewLinkedList();
			}break;
			case 9:{
				System.out.println("exiting...");
				System.exit(0);
			}
			}
		}
	}

}
