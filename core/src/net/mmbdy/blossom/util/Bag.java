/** 
 * Copyright (c) 2016, Peter Vu. All rights reserved.
 * License terms are in the included LICENSE.txt file.
 */
package net.mmbdy.blossom.util;

import com.badlogic.gdx.utils.reflect.ArrayReflection;

/**
 * An unordered collection of objects which includes duplicates.
 * @author Peter Vu
 *
 */
public class Bag<T> {

	//TODOC: Document
	//TODO: Implement a hash table to binary search tree to speed up to O(1) or O(logn)

	/**
	 * The array of items. It provides direct access to the items within the bag.
	 */
	public T[] items;

	/**
	 * The current size of the bag
	 */
	private int size = 0;

	/**
	 * Creates a default bag with a capacity of 16.
	 */
	public Bag() {
		this(16);
	}

	/**
	 * Creates a bag with specified capacity
	 */
	public Bag(int capacity) {
		items = (T[])new Object[capacity];
	}

	//public Bag(Bag<? extends T> bag) {
	//	
	//}

	//TODO: Maybe I shouldn't name it value because we are reference checking. Check this class
	public void add(T value) {
		T[] items = this.items;
		if (size == items.length) items = grow();
		items[size++] = value;
	}
	
	public T get(int index) {
		if (index >= size) throw new IndexOutOfBoundsException(
				"Index cannot be >= size: " + index + " >= " + size);
		return items[index];
	}

	public void set(int index, T value) {
		if (index >= size) throw new IndexOutOfBoundsException(
				"Index cannot be >= size: " + index + " >= " + size);
		//resize(index * 2);
		this.size = Math.max(this.size, index + 1);
		items[index] = value;
	}

	public boolean contains(T value) {
		T[] items = this.items;
		int i = size - 1;
		if (value != null) {
			while (i >= 0) {
				if (items[i--] == value) return true;
			}
		}
		return false;
	}

	public T remove(int index) {
		if (index >= size) throw new IndexOutOfBoundsException(
				"Index cannot be >= size: " + index + " >= " + size);
		T[] items = this.items;
		T value = (T)items[index];
		size--;
		items[index] = items[size];
		items[size] = null;
		return value;
	}

	public T removeLast() {
		if(size == 0) throw new IllegalStateException("Bag is empty.");
		--size;
		T item = items[size];
		items[size] = null;
		return item;
	}

	public boolean remove(T value) {
		//TODO: For this and contains, check for equals null
		T[] items = this.items;
		if(value != null) {
			for(int i = 0, n = size; i< n; i++) {
				if(items[i] == value) {
					remove(i);
					return true;
				}
			}
		}
		return false;
	}

	public int size() {
		return size;
	}

	public int getCapacity() {
		return items.length;
	}

	public boolean isIndexWithinBounds(int index) {
		return index < getCapacity();
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void clear() {
		T[] items = this.items;
		for(int i = 0, n = size; i < n; i++) {
			items[i] = null;
		}
		size = 0;
	}

	public T[] grow() {
		return resize(Math.max(8, (int)(size * 1.75f)));
	}
	
	public T[] shrink() {
		if(items.length != size) resize(size);
		return items;
	}
	
	public T[] ensureCapacity(int minimumSize) {
		if(minimumSize >= items.length) resize(Math.max(8, minimumSize));
		return items;
	}

	protected T[] resize(int newSize) {
		T[] items = this.items;
		T[] newItems = (T[])ArrayReflection.newInstance(items.getClass().getComponentType(),
				newSize);
		System.arraycopy(items, 0, newItems, 0, Math.min(size, newItems.length));
		this.items = newItems;
		return newItems;
	}
}
