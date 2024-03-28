tacha just read the slides for details but here is the rundown:

1. collections framework
	- unified architecture for fucking around with collections
	- makes programming easier while improving performance
	- some bs about allowing for interoperability between apis, makes designing 
	code easier, etc
	
	collections has 3 main sub-interfaces -> list, queue, set
	
	list: implemented by arraylist, linkedlist, etc
	queue: implemented by priorityqueue
		- this interface has a sub-interface called deque, implemented by
		linkedlist and arraydeque
	set: implemented by hashset, linkedhashset
	
2. linkedlist
	- it's a collection of nodes
	- a node just contains a reference to an element and the address to the
	next node, kinda like this;
	class ListNode{//this shit aint in the slides i just do fuck ton of leetcode
		Object obj;
		ListNode next;
		//the rest of the owl
	}
	
	they have a fancy term for going to the next node called node jumping? so dumb
	it's basically setting your node to the next one
	ListNode node = //whatever fucking constructor
	node = node.next;
	
	unlike arrays, you can put nodes whereever the fuck you want
	this make it useful when you're running out of ram space or something
	like, for arrays you have to dedicate a bunch of uninterrupted space
	but what if you don't have space for that shit? just use linkedlist, since
	the nodes can go anywhere as long as it has space for the node's element and the reference
	to the next one
	
	2.1 operations in the linked list
	
	there's like 5 main ones
	- creation
	- insertion / deletion
	- traversing
	- searching
	- concatenation
	
	he showed like a bunch of shit you could do with nodes like:
	head = head.next;
	head.next = head.next.next;
	head.next.next.next.next = head;
	
	he got a diagram on how it works in the slides but here's what's happening in each line:
	head = head.next; -> the node next to the head, becomes the head
	head.next = head.next.next; -> the node next to the node next to the head, becomes the node next to the head
	head.next.next.next.next = head;
	-> the node 5 elements down the next chain now becomes the head
	
	2.2 insertion
	we got 3 main methods for insertion:
	- insertion at the beginning
	- insertion at the middle
	- insertion at the end
	
	the first one is easy. you just make a new list node, fill it up with whatever element, and then
	set the next of that node to the head of the linkedlist
	public void insertAtFirst(int val) {
		Node n;
		n = new Node();
		n.setData(val);
		n.setNext(head);
		head = n;
	}
	
	the second one, you have to set the next of the node to your new node, then the next of your new
	node to the old next of the node before the new node //very confusing
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
	
	the last one, you go through all the elements;
	then you just add your new node to the last node possible
	public void insertAtLast(int val) {
		Node n = new Node(), t = head;
		n.setData(val);
		if (t == head) {
			head = n;
		}
		else {
			while (t.getNext() != null) {
				t = t.getNext();
			}
			t.setNext(n);
		}
		size++;
	}
	
	2.3 deletion
	
	
	
	