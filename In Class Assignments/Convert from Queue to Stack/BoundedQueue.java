/**
 * A first-in, first-out bounded collection of objects.
 */
public class BoundedQueue<E> extends AbstractCollection<E> {
	/**
	 * Constructs an empty queue.
	 * 
	 * @param capacity
	 *            the maximum capacity of the queue
	 * @precondition capacity > 0
	 */
	public BoundedQueue(int capacity) {
		elements = new Object[capacity];
		count = 0;
		head = 0;
		tail = 0;
	}

	public Iterator<E> iterator() {
		return new Iterator<E>() {		// iterates from right to left, where the top of the stack is the tail
			public boolean hasNext() {
				return visited > 0;		
			}

			public E next() {
				int index = (head - visited) % elements.length;
				E r = (E) elements[index];
				visited--;
				return r;
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}

			private int visited = count;
		};
	}

	/**
	 * Remove object at head.
	 * 
	 * @return the object that has been removed from the queue
	 * @precondition size() > 0
	 */
	public E remove() {
		head = (head - 1) % elements.length; // replaced tail with head so that the top is removed first
		E r = (E) elements[head];
		count--;
		return r;
	}

	/**
	 * Append an object at tail.
	 * 
	 * @param anObject
	 *            the object to be appended
	 * @return true since this operation modifies the queue. (This is a requirement
	 *         of the collections framework.)
	 * @precondition !isFull()
	 */
	public boolean add(E anObject) {
		elements[head] = anObject; 			// replaced tail with head so that the added object is the first
		head = (head + 1) % elements.length; 
		count++;
		return true;
	}

	public int size() {
		return count;
	}

	/**
	 * Checks whether this queue is full.
	 * 
	 * @return true if the queue is full
	 */
	public boolean isFull() {
		return count == elements.length;
	}

	/**
	 * Gets object at head.
	 * 
	 * @return the object that is at the head of the queue
	 * @precondition size() > 0
	 */
	public E peek() {
		return (E) elements[head];
	}

	private Object[] elements;
	private int head;
	private int tail;
	private int count;
}
