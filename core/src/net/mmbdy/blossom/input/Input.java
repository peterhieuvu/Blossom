/** 
 * Copyright (c) 2016, Peter Vu. All rights reserved.
 * License terms are in the included LICENSE.txt file.
 */
package net.mmbdy.blossom.input;

import com.badlogic.gdx.Input.Keys;

import net.mmbdy.blossom.input.ITrigger.Type;

/**
 * Use to poll User input data based on control bindings
 * @author Peter Vu
 */
public class Input {
	
	/**
	 * Contains control binds data
	 * @author Peter Vu
	 */
	public static class Binds {
		public static Bind left = new Bind("Left", new KeyBind(Type.Keyboard, 2, Keys.A, Keys.LEFT));
		public static Bind right = new Bind("Right", new KeyBind(Type.Keyboard, 2, Keys.D, Keys.RIGHT));
		public static Bind up = new Bind("Up", new KeyBind(Type.Keyboard, 2, Keys.W, Keys.UP));
		public static Bind down = new Bind("Down", new KeyBind(Type.Keyboard, 2, Keys.S, Keys.DOWN));
		public static Bind boost = new Bind("Boost", new KeyBind(Type.Keyboard, 2, Keys.SHIFT_LEFT, Keys.SHIFT_RIGHT));
	}
	
	//TODO: Implement own Input API, abstract between platforms

}
