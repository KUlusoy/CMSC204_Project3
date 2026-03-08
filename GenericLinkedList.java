import java.util.*;


public class GenericLinkedList <T> implements Iterable<T>{
	
	private class Node{
		private T data;
		private Node next;
		private Node prev;
		
		private Node (T dataPortion){
			this(dataPortion, null);
		}
		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		}
		private T getData() {
			return data;
		}

		private Node getNextNode() {
			return next;
		}

	}
	
	
	private int size;
	private Node firstNode;
	private Node lastNode;
	
	public GenericLinkedList() {
		firstNode = null;
		lastNode = null;
		size = 0;
	}
	Boolean contains(T element) {
		boolean found = false;
		Node currentNode = firstNode;
		while(currentNode != null) {
			if(element.equals(currentNode.getData())) {
				found = true;
				break;
			}
			else {
				currentNode = currentNode.getNextNode();
			}
		}
		return found;
	}
	T get(int index) {
		if(index < 0 || index>= size) {
			throw new IndexOutOfBoundsException();
		}
		Node current = firstNode;
		for(int i = 0; i < index; i++) {
			current = current.next;
		}
		return current.data;
	}
	T getFirst() {
		return firstNode.data;
	}
	T getLast() {
		return lastNode.data;
	}
	Boolean isEmpty() {
		if(firstNode == null && lastNode == null) {
			return true;
		}
		else {
			return false;
		}
	}
	public ListIterator<T> iterator(){
		return new GenericIterator();
	}
	
	T remove(int index) {
		Node current = firstNode;
		for(int i =0; i < index; i++) {
			current = current.next;
		}
		current.data = firstNode.data;
		firstNode = firstNode.next;
		if(firstNode != null) {
			firstNode.prev = null;
		}
		else {
			lastNode = null;
		}
		size--;
		return current.data;
	}
	private Node getReferenceTo(T anEntry) {
		boolean found = false;
		Node currentNode = firstNode;
		while(!found && (currentNode != null)) {
			if(anEntry.equals(currentNode.data)) {
				found = true;
			}
			else {
				currentNode = currentNode.next;
			}
			
		}
		return currentNode;
	}
	Boolean remove(T element) {
		boolean result = false;
		Node nodeN = getReferenceTo(element);
		if(nodeN != null) {
			nodeN.data = firstNode.data;
			firstNode = firstNode.next;
			size--;
			result = true;
		}
		return result;
	}
	T removeFirst() {
		T data = firstNode.data;
		firstNode = firstNode.next;
		if(firstNode != null) {
			firstNode.prev = null;
		}
		else {
			lastNode = null;
		}
		size--;
		return data;
	}
	T removeLast() {
		T data = lastNode.data;
		lastNode = lastNode.prev;
		if(lastNode != null) {
			lastNode.next = null;
		}
		else {
			lastNode = null;
		}
		size--;
		return data;
	}
	int size() {
		return size;
	}
	Object[] toArray() {
		Object[] array = new Object[size];
		Node current = firstNode;
		for(int i = 0; i < size; i++) {
			array[i] = current.data;
			current = current.next;
		}
		return array;
	}
	public void addFirst(T element) {
	    Node newNode = new Node(element);
	    if (firstNode == null) {
	        firstNode = newNode;
	        lastNode = newNode;
	    } else {
	        newNode.next = firstNode;
	        firstNode.prev = newNode;
	        firstNode = newNode;
	    }
	    size++;
	}
	public void addLast(T element) {
	    Node newNode = new Node(element);
	    if (lastNode == null) {
	        firstNode = newNode;
	        lastNode = newNode;
	    } else {
	        newNode.prev = lastNode;
	        lastNode.next = newNode;
	        lastNode = newNode;
	    }
	    size++;
	}
	private class GenericIterator implements ListIterator<T> {
	    private Node nextNode;
	    private Node lastReturned;

	    GenericIterator() {
	        nextNode = firstNode;
	        lastReturned = null;
	    }

	    public boolean hasNext() {
	        return nextNode != null;
	    }

	    public T next() {
	        if (!hasNext()) throw new NoSuchElementException();
	        lastReturned = nextNode;
	        nextNode = nextNode.next;
	        return lastReturned.data;
	    }

	    public boolean hasPrevious() {
	        if (nextNode == null) return lastNode != null;
	        return nextNode.prev != null;
	    }

	    public T previous() {
	        if (!hasPrevious()) throw new NoSuchElementException();
	        if (nextNode == null) nextNode = lastNode;
	        else nextNode = nextNode.prev;
	        lastReturned = nextNode;
	        return lastReturned.data;
	    }

	    public void remove() {
	        if (lastReturned == null) throw new IllegalStateException();
	        lastReturned.data = firstNode.data;
	        firstNode = firstNode.next;
	        if (firstNode != null) firstNode.prev = null;
	        else lastNode = null;
	        size--;
	        lastReturned = null;
	    }

	    public int nextIndex(){ 
	    	
	    	throw new UnsupportedOperationException(); 
	    }
	    
	    public int previousIndex() 
	    { 
	    	throw new UnsupportedOperationException(); 
	    }
	    
	    public void set(T e){ 
	    	throw new UnsupportedOperationException(); 
	    }
	    
	    public void add(T e){ 
	    	throw new UnsupportedOperationException(); 
	    }
	}
	public void clear() {
	    firstNode = null;
	    lastNode = null;
	    size = 0;
	}
}
