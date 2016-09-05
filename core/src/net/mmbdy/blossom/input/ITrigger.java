/** 
 * Copyright (c) 2016, Peter Vu. All rights reserved.
 * License terms are in the included LICENSE.txt file.
 */
package net.mmbdy.blossom.input;

/**
 * A trigger for a control bind
 * @author Peter Vu
 *
 */
public interface ITrigger {
	
	/**
	 * The Bind category a certain {@link BindSet} belongs to
	 * @author Peter Vu
	 *
	 */
	public enum Type {
		Keyboard, Alternate, Controller, Mouse
	}
	
	/**
	 * @return Value of the current state of the Bind
	 */
	public float getData();
	
	/**
	 * @return Whether or not the Bind is currently down
	 */
	public boolean isDown();
	
	/**
	 * @return Whether or not the Bind was just pressed
	 */
	public boolean isJustPressed();

}
