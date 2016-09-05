/** 
 * Copyright (c) 2016, Peter Vu. All rights reserved.
 * License terms are in the included LICENSE.txt file.
 */
package net.mmbdy.blossom.input;

/**
 * @author Peter Vu
 *
 */
public class Macro extends BindSet {

	//TODO: Finish this class
	
	/**
	 * @param name
	 * @param slots
	 * @param triggers
	 */
	public Macro(Type name, int slots, int[] triggers) {
		super(name, slots, triggers);
	}

	@Override
	public float getData() {
		return 0;
	}

	@Override
	public boolean isDown() {
		return false;
	}

	@Override
	public boolean isJustPressed() {
		return false;
	}

}
