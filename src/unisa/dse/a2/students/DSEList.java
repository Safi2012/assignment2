package unisa.dse.a2.students;

import unisa.dse.a2.interfaces.List;

/**
 * @author Sulaiman Safi
 *
 */
public class DSEList implements List {
	
	public Node head;
	private Node tail;

	public DSEList() {
		 head = null;
		 tail = null; 
		
	}
	public DSEList(Node head_) {
		head = head_;
		tail = head;
	}
	
	//Takes a list then adds each element into a new list
	public DSEList(DSEList other) { // Copy constructor. 
		Node curr = other.head;
		while(curr!=null)
		{
			this.add(curr.getString());
			curr=curr.next;
		}
	}

	//remove the String at the parameter's index
	public String remove(int index) {
		if (index >= size() || index < 0) {
			throw new IndexOutOfBoundsException("pos = " + index + " does not exist");
		}
		Node toBeRemoved = head;
		for (int i = 0; i < index; ++i) {
			toBeRemoved = toBeRemoved.next;
		}
		if (toBeRemoved == null)
			return null;
		if(toBeRemoved==head)
		{
			head.prev=null;
			head=head.next;
			return toBeRemoved.getString();
		}
		else if(toBeRemoved==tail)
		{
			tail=tail.prev;
			tail.next=null;
			return toBeRemoved.getString();
		}
		Node previous = toBeRemoved.prev;
		Node next = toBeRemoved.next;

		previous.next = next;
		if (next != null) {
			next.prev = toBeRemoved.prev;
		}
		return toBeRemoved.getString();

	}

	//returns the index of the String parameter 
	public int indexOf(String obj) {
		Node curr=head;
		for(int i=0; i<size(); i++)
		{
			if(obj.equals(curr.getString()))
			{
				return i;
			}
			curr=curr.next;
		}
		return -1;
	}
	
	//returns String at parameter's index
	public String get(int index) {
		Node curr=head;
		for(int i=0; i<size(); i++)
		{
			if(i==index)
			{
				return curr.getString();
			}
			curr=curr.next;
		}
		return null;  // or throw an exception for index out of bounds 
	}

	//checks if there is a list
	public boolean isEmpty() {
		if(size()==0)
			return true;
		return false;
	}

	//return the size of the list
	public int size() {
		Node curr=head;
		int size=0;
		while(curr!=null)
		{
			curr=curr.next;
			size++;
		}
		return size;
	}
	
	//Take each element of the list a writes them to a string / Override method provides a different implementation for a method that is already defined 
	@Override
	public String toString() {
		Node next=head;
		String st="";
		while (next != null) {
			if(next.next!=null)
				st+=(next.getString().toString() + " ");
			else
				st+=(next.getString().toString());
				next = next.next;
		}
		return st;
	}

	//add the parameter String at of the end of the list
	public boolean add(String obj) {
		Node newNode=new Node(null,null,obj);
		if(head==null)
		{
			head=newNode;
			tail=newNode;
			return true;
		}
		tail.next=newNode;
		newNode.prev=tail;
		tail=tail.next;
		return true;
	}

	//add String at parameter's index
	public boolean add(int index, String obj){if (index > size() || index < 0) {
		throw new IndexOutOfBoundsException("pos = " + index + " does not exist");
	}
	if(index==size()) {
		add(obj);
		return true;
	}
	Node node=head;
	for (int i = 0; i < index; ++i) {
		node = node.next;
	}
	Node newNode=new Node(null,null,obj);
	if(head==node)
	{
		newNode.next=head;
		head.prev=newNode;
		head=head.prev;
		return true;
	}
	newNode.next=node;
	newNode.prev=node.prev;
	node.prev.next=newNode;
	node.prev=newNode;
	return true;
		
	}

	//searches list for parameter's String return true if found
	public boolean contains(String obj) {
		Node curr=head;
		for(int i=0; i<size(); i++)
		{
			if(obj.equals(curr.getString()))
			{
				return true;
			}
			curr=curr.next;
		}
		return false;
	}

	//removes the parameter's String form the list
	public boolean remove(String obj) {
		if (head == null || obj == null) {
            return false;
        }
        Node curr=head;
        Node del=null;
        for(int i=0; i<size(); i++)
		{
			if(obj.equals(curr.getString()))
			{
				del=curr;
				break;
			}
			curr=curr.next;
		}
        if (head.equals(del)) 
            head = del.next;
        if (del.next != null) 
            del.next.prev = del.prev;
        if (del.prev != null) 
            del.prev.next = del.next;
        return true;
	}
	
	@Override
	public int hashCode() {
		int code=0;
		Node curr=head;
		for(int i=0; i<size(); i++)
		{
			code+=(Integer.parseInt(curr.getString()));
			curr=curr.next;
		}
		return code;
	}

	@Override
	public boolean equals(Object other) {
		if(this.toString().equals(other.toString()))
			return true;
		return false; 
	}
	
}
