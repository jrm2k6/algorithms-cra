package assignment2;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class Deque<Item> implements Iterable<Item> {
	private Node first= null;
	private int size = 0;
	
	private class Node {
		Item item;
		Node next;
		Node previous;
	}
	
	public Deque() {
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public int size() {
		return size;
	}
	
	public void addFirst(Item item) {
		if (item == null) throw new NullPointerException("You try to add a null element to the queue");
		
		Node n = new Node();
		n.item = item;
		
		if (isEmpty()) {
			first = n;
		} else {
			Node oldFirst = first;
			n.next = oldFirst;
			oldFirst.previous = n;
			first = n;
		}
		
		size++;
	}
	
	public void addLast(Item item) {
		if (item == null) throw new NullPointerException("You try to add a null element to the queue");
		
		Node newNode = new Node();
		newNode.item = item;
		if (isEmpty()) {
			first = newNode;
		} else {
			Node current = first;
			
			
			while (current.next != null) {
				current = current.next;
			}
			
			current.next = newNode;
			newNode.previous = current;
		}
		size++;
	}
	
	public Item removeFirst() {
		if (first != null) {
			Node toBeReturned = first;
			if (size == 1) {
				first = null;
			} else {
				Node newFirst = first.next;
				toBeReturned.next = null;
				toBeReturned.previous = null;
				newFirst.previous = null;
				first = newFirst;
			}
			size--;
			return toBeReturned.item;
		} else {
			throw new NoSuchElementException("trying to get the first element of an empty queue");
		}
	}
	
	public Item removeLast() {
		if (first != null) {
			Item last = null;
			Node toBeReturned = first;
			if (size == 1) {
				last = first.item;
				first = null;
			} else {
				while (toBeReturned.next != null) {
					toBeReturned = toBeReturned.next;
				}
				last = toBeReturned.item;
				toBeReturned.previous.next = null;
				toBeReturned = null;
			}
			
			size--;
			return last;
		} else {
			throw new NoSuchElementException("trying to get the last element of an empty queue");
		}
	}
	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		class DequeIterator implements Iterator<Item> {

			private Node current = first;
			
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return current.next != null;
			}

			@Override
			public Item next() {
				// TODO Auto-generated method stub
				Item item = current.item;
				current = current.next;	
				return item;
			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub
				/* not supported */
				throw new UnsupportedOperationException();
			}
			
		}
		
		return new DequeIterator();
	}
	
}
