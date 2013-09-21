package assignment2;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.introcs.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item>{
	private Item[] items;
	private int nbElements = 0;
	
	@SuppressWarnings("unchecked")
	public RandomizedQueue() {
		this.items = (Item[]) new Object[1];	
	}
	
	public boolean isEmpty() {
		return nbElements == 0;
	}
	
	@SuppressWarnings("unchecked")
	private void resize(int capacity) {
        assert capacity >= nbElements;
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < nbElements; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }
	
	public int size() {
		return nbElements;
	}
	
	public void enqueue(Item item) {
		if (item == null) throw new NullPointerException("You try to enqueue a null element to the queue");
		if (nbElements == items.length) {
			resize(2 * items.length);
		}
		
		items[nbElements++] = item;
	}
	
	public Item dequeue() {
		if (isEmpty()) throw new NoSuchElementException("trying to dequeue on an empty queue");
		int i = StdRandom.uniform(nbElements);
	    Item ret = items[i];
	    items[i] = items[--nbElements];
	    items[nbElements] = null;
	    
	    if (items.length / 4 > nbElements) {
	           resize(items.length / 4);
	    }
	    
	    System.out.println(ret);
	    return ret;
	}
	
	public Item sample() {
		if (isEmpty()) throw new NoSuchElementException("trying to sample on an empty queue");
		return items[StdRandom.uniform(nbElements)];
	}
	
	@Override
	public Iterator<Item> iterator() {
		class DequeIterator implements Iterator<Item> {
			private int currentIndex = 0;
			 private int[] shuffled = new int[nbElements];
			
			@Override
			public boolean hasNext() {
				if (currentIndex == 0) {
					for (int i = 0; i < nbElements; i++) {
						shuffled[i] = i;
					}
					StdRandom.shuffle(shuffled);
				}
				// TODO Auto-generated method stub
				return currentIndex < nbElements;
			}

			@Override
			public Item next() {
				if (currentIndex >= nbElements || size() == 0) throw new java.util.NoSuchElementException();
				if (currentIndex == 0) {
					for (int i = 0; i < nbElements; i++) {
						shuffled[i] = i;
					}
					StdRandom.shuffle(shuffled);
				}
				return items[shuffled[currentIndex++]];
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
