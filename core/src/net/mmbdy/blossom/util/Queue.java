/** 
 * Copyright (c) 2016, Peter Vu. All rights reserved.
 * License terms are in the included LICENSE.txt file.
 */
package net.mmbdy.blossom.util;

import java.util.NoSuchElementException;

import com.badlogic.gdx.utils.reflect.ArrayReflection;

/**
 * A resizable array of objects with add and remove at the beginning and end. Deque functionality is provided with removeLast and addFirst.
 * @author Peter Vu
 *
 */
public class Queue<T> {

	//TODOC: Document
	//TODO: Iterable

	/**
	 * Contains the values in the queue. The head and tail go around in a circle and wrap at the end.
	 */
	protected T[] values;

	/**
	 * Index of the last element
	 */
	protected int head = 0;

	/**
	 * Index of the last element
	 */
	protected int tail = 0;

	/**
	 * Number of elements within the queue
	 */
	public int size = 0;

	/**
	 * Creates a new queue with an initial size of 16
	 */
	public Queue() {
		this(16);
	}

	/**
	 * Creates a new Queue with the specified initial size
	 * @param initialSize the number of values the Queue can hold without needing to resize the backing array
	 */
	public Queue(int initialSize) {
		this.values = (T[])new Object[initialSize];
	}

	/**
	 * Append the given object to the tail. 
	 */
	public void addLast(T object) {
		T[] values = this.values;
		if (size == values.length) {
			resize(values.length << 1);
			values = this.values;
		}

		values[tail++] = object;
		if (tail == values.length) tail = 0;
		size++;
	}

	/**
	 * Append the given object to the head. 
	 */
	public void addFirst(T object) {
		T[] values = this.values;

		if (size == values.length) {
			resize(values.length << 1);
			values = this.values;
		}

		int head = this.head;
		head--;
		if (head == -1) head = values.length - 1;
		values[head] = object;

		this.head = head;
		this.size++;
	}

	public void ensureCapacity(int minimumSize) {
		if (values.length < minimumSize) resize(minimumSize);
	}

	protected void resize(int newSize) {
		final T[] values = this.values;
		final int head = this.head;
		final int tail = this.tail;

		final T[] newAry = (T[])ArrayReflection.newInstance(values.getClass().getComponentType(),
				newSize);
		if (head < tail) {
			//Continuous
			System.arraycopy(values, head, newAry, 0, tail - head);
		} else if (size > 0) {
			//Wrapped
			final int rest = values.length - head;
			System.arraycopy(values, head, newAry, 0, rest);
			System.arraycopy(values, 0, newAry, rest, tail);
		}
		this.values = newAry;
		this.head = 0;
		this.tail = size;
	}

	public T removeFirst() {
		if (size == 0) throw new NoSuchElementException("The queue is empty.");

		final T[] values = this.values;
		final T result = values[head];
		head++;
		if (head == values.length) head = 0;
		size--;
		return result;
	}

	public T removeLast() {
		if (size == 0) throw new NoSuchElementException("The queue is empty.");

		final T[] values = this.values;
		int tail = this.tail;
		tail--;
		if (tail == -1) tail = values.length - 1;
		final T result = values[tail];
		values[tail] = null;
		this.tail = tail;
		size--;
		return result;
	}

	//TODO: Check for null
	public int indexOf(T value) {
		if (size == 0) return -1;
		T[] values = this.values;
		int head = this.head, tail = this.tail;
		if (head < tail) {
			for (int i = head, n = tail; i < n; i++) {
				if (values[i] == value) return i;
			}
		} else {
			for (int i = head, n = values.length; i < n; i++) {
				if (values[i] == value) return i - head;
			}
			for (int i = 0, n = tail; i < n; i++) {
				if (values[i] == value) return i + values.length - head;
			}
		}
		return -1;
	}

	//TODO: Allow checking for both value and reference
	public boolean removeValue(T value) {
		int index = indexOf(value);
		if (index == -1) return false;
		removeIndex(index);
		return true;
	}

	public T removeIndex(int index) {
		if (index < 0) throw new IndexOutOfBoundsException("Index cannot be < 0: " + index);
		if (index >= size) throw new IndexOutOfBoundsException(
				"index cannot be >= size: " + index + " >= " + size);

		T[] values = this.values;
		int head = this.head, tail = this.tail;
		index += head;
		T value;
		if (head < tail) { //index is between head and tail
			value = (T)values[index];
			System.arraycopy(values, index + 1, values, index, tail - index);
			values[tail] = null;
			this.tail--;
		} else if (index >= values.length) { //index is between 0 and tail
			index -= values.length;
			value = (T)values[index];
			System.arraycopy(values, index + 1, values, index, tail - index);
			this.tail--;
		} else { //index is between head and values.length
			value = (T)values[index];
			System.arraycopy(values, head, values, head + 1, index - head);
			values[head] = null;
			this.head++;
		}
		size--;
		return value;
	}

	public T first() {
		if(size == 0) throw new NoSuchElementException("The queue is empty.");
		return values[head];
	}

	public T last() {
		if(size == 0) throw new NoSuchElementException("The queue is empty.");
		final T[] values = this.values;
		int tail = this.tail;
		tail--;
		if(tail == -1) tail = values.length - 1;
		return values[tail];
	}

	public T get(int index) {
		if (index < 0) throw new IndexOutOfBoundsException("Index cannot be < 0: " + index);
		if (index >= size) throw new IndexOutOfBoundsException("Index cannot be >= size: " + index + " >= " + size);
		final T[] values = this.values;
		
		int i = head + index;
		if(i >= values.length) i -= values.length;
		return values[i];
	}

	public void clear() {
		if(size == 0) return;
		final T[] values = this.values;
		final int head = this.head;
		final int tail = this.tail;
		
		if(head < tail) {
			//Continuous
			for(int i = head; i < tail; i++) {
				values[i] = null;
			}
		} else {
			//Wrapped
			for(int i = head; i < values.length; i++) {
				values[i] = null;
			}
			for(int i = 0; i < tail; i++) {
				values[i] = null;
			}
		}
		this.head = 0;
		this.tail = 0;
		this.size = 0;
	}

	//TODO: Implement toString, hashCode, and equals
}
