package unisa.dse.a2.students;

import students.DSEListGeneric;
import students.NodeGeneric;
import unisa.dse.a2.interfaces.ListGeneric;

/**
 * @author Sulaiman Safi 
 *
 */
public class DSEListGeneric<T> implements ListGeneric<T> {
	
	public NodeGeneric<T> head;
	private NodeGeneric<T> tail;

	public DSEListGeneric() {
		head=null;
		tail=null;
	}
	public DSEListGeneric(NodeGeneric<T> head_) {
		head=head_;
		tail=head_;
	}
	
	//Takes a list then adds each element into a new list
	public DSEListGeneric(DSEListGeneric<T> other) { // Copy constructor.
		NodeGeneric<T> curr=other.head;
		while(curr!=null)
		{
			this.add(curr.get());
			curr=curr.next;
		}
	}
	//remove and return the item at the parameter's index
	public T remove(int index) {
		if (index >= size() || index < 0) {
			throw new IndexOutOfBoundsException("pos = " + index + " does not exist");
		}
		NodeGeneric<T> toBeRemoved = head;
		for (int i = 0; i < index; ++i) {
			toBeRemoved = toBeRemoved.next;
		}
		if (toBeRemoved == null)
			return null;
		if(toBeRemoved==head)
		{
			head.prev=null;
			head=head.next;
			return toBeRemoved.get();
		}
		else if(toBeRemoved==tail)
		{
			tail=tail.prev;
			tail.next=null;
			return toBeRemoved.get();
		}
		NodeGeneric<T> previous = toBeRemoved.prev;
		NodeGeneric<T> next = toBeRemoved.next;

		previous.next = next;
		if (next != null) {
			next.prev = toBeRemoved.prev;
		}
		return toBeRemoved.get();
	}


	//returns the index of the String parameter 
	public int indexOf(T obj) {
		if (obj == null)
			return -1;
		NodeGeneric<T> curr = head;
		for(int i=0; i<size(); i++)
		{
			if(obj.equals(curr.get()))
			{
				return i;
			}
			curr=curr.next;
		}
		return -1;
	}
	
	//returns item at parameter's index
	public T get(int index) {
		
		if (index > size() || index<0)
			return null;
		NodeGeneric<T> node = head;
		for (int i = 0; i < index; ++i) {
			node = node.next;
		}

		return (node != null) ? node.get() : null;
	}

	//checks if there is a list
	public boolean isEmpty() {
		boolean isEmpty = (size() > 0) ? false : true;
		return isEmpty;
		
	}

	//return the size of the list
	public int size() {
	}
	
	//Take each element of the list a writes them to a string 
	@Override
	public String toString() {
	}

	//add the parameter item at of the end of the list
	public boolean add(Object obj) {
	}

	//add item at parameter's index
	public boolean add(int index, Object obj) {
	}

	//searches list for parameter's String return true if found
	public boolean contains(Object obj) {
	}

	//removes the parameter's item form the list
	public boolean remove(Object obj) {
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
