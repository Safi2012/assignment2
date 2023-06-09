package unisa.dse.a2.students;

import students.Node;
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
	}

	//return the size of the list
	public int size() {
	}
	
	//Take each element of the list a writes them to a string 
	@Override
	public String toString() {
	}

	//add the parameter String at of the end of the list
	public boolean add(String obj) {
	}

	//add String at parameter's index
	public boolean add(int index, String obj) {
	}

	//searches list for parameter's String return true if found
	public boolean contains(String obj) {
	}

	//removes the parameter's String form the list
	public boolean remove(String obj) {
	}
	
	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public boolean equals(Object other) {
		return true;
	}
	
}
