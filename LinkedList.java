class Node {
	int data;
	Node next;
	
	Node(int data) {
		this.data = data;
		this.next = null;
	}
}

public class LinkedList {
	private Node head;
	
	void insertFront(int newData){
		Node newNode = new Node(newData);
		newNode.next = head;
		head = newNode;
	}
	
	void insertLast(int data){
		Node newNode = new Node(data);
		
		//if list empty
		if(head == null){
			head = newNode;
			return;
		}
		
		//traverse last node
		Node curr = head;
		while(curr.next != null){
			curr = curr.next;
		}
		curr.next = newNode;
	}
	
	void deleteItem(int data){
		//todo complete this
		//also handle for the case when the data is not in the list
		
		if(head == null) {
			System.out.println("List is empty");
			return;
		}
		
		Node curr = head;
		Node prev = null;
		
		//case: first data
		if(curr != null && curr.data == data){
			head = curr.next;
			return;
		}
		
		//case: search node to tdelete
		while( curr != null && curr.data != data){
			prev = curr;
			curr = curr.next;
		}
		
		//case: data is not in the list
		if(curr == null){
			System.out.println("Data " + data + " is not in the list.");
			return;
		}
	
		prev.next = curr.next;
	}
	
	void display(){
		Node cur = head;
		while(cur != null){
			System.out.print(cur.data + " ");
			cur = cur.next;
		}
		
		System.out.println();
	}
	
	public static void main(String[] args){
		LinkedList list = new LinkedList();
        list.insertLast(3);
        list.insertFront(1);
        list.insertLast(7);
        list.insertFront(2);
        list.insertFront(9);

        System.out.print("The linked list is: ");
        list.display();

        list.deleteItem(7);
        list.deleteItem(10);

        
        System.out.print("The linked list is: ");
        list.display();
	}
}

