/** 
 * Copyright (c) 2016, Peter Vu. All rights reserved.
 * License terms are in the included LICENSE.txt file.
 */
package net.mmbdy.blossom.input;

import net.mmbdy.blossom.Blossom;

/**
 * A set of binds for the Keyboard
 * @author Peter Vu
 *
 */
public class KeyBind extends BindSet {

	/**
	 * Set of keys to be polled for input. Standard constructor that is called by all other constructors.
	 * @param type    The type of bind set
	 * @param slots    The maximum amount of triggers for the bind set
	 * @param triggers   The triggers for the bind set
	 */
	public KeyBind(Type type, int slots, int... triggers) {
		super(type, slots, triggers);
	}

	@Override
	public float getData() {
		for (int i = 0; i < triggers.length; i++) {
			if (Blossom.input.isKeyPressed(triggers[i])) return 1;
		}
		return 0;
	}

	@Override
	public boolean isDown() {
		for (int i = 0; i < triggers.length; i++) {
			if (Blossom.input.isKeyPressed(triggers[i])) return true;
		}
		return false;
	}

	@Override
	public boolean isJustPressed() {
		for (int i = 0; i < triggers.length; i++) {
			if (Blossom.input.isKeyJustPressed(triggers[i])) return true;
		}
		return false;
	}

}
