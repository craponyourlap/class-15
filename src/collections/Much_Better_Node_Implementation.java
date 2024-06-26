package collections;

class Node {
	int data;
	Node next;

	Node(int data)
	{
		this.data = data;
		next = null;
	}
}

class LinkedList {
	Node head;

	// Inserts a new node at the front of the list
	void push(int new_data)
	{
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}

	// Appends a new node at the end of the list
	void append(int new_data)
	{
		Node new_node = new Node(new_data);

		if (head == null) {
			head = new_node;
			return;
		}

		Node last = head;
		while (last.next != null) {
			last = last.next;
		}

		last.next = new_node;
	}

	// Prints the contents of the linked list
	void printList()
	{
		Node node = head;
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}
}

public class Much_Better_Node_Implementation {
	public static void main(String[] args)
	{
		LinkedList linkedList = new LinkedList();

		// Insert nodes at the beginning of the linked list
		linkedList.push(6);
		linkedList.push(5);
		linkedList.push(4);
		linkedList.push(3);
		linkedList.push(2);

		System.out.print("Created Linked list is: ");
		linkedList.printList();

		// Insert 1 at the end
		linkedList.append(1);

		System.out.print(
			"\nAfter inserting 1 at the end: ");
		linkedList.printList();
	}
}

