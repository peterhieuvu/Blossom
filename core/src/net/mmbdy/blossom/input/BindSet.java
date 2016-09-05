/** 
 * Copyright (c) 2016, Peter Vu. All rights reserved.
 * License terms are in the included LICENSE.txt file.
 */
package net.mmbdy.blossom.input;

import com.badlogic.gdx.utils.reflect.ArrayReflection;

/**
 * A set of binds
 * @author Peter Vu
 */
public abstract class BindSet implements ITrigger {

	/**
	 * Name of the bind set
	 */
	public final Type type;

	/**
	 * Maximum amount of triggers
	 */
	public final int slots;

	/**
	 * Int codes for the triggers of the current set of binds
	 */
	protected int[] triggers;

	/**
	 * Standard constructor for Bindset.
	 * @param type    The type of bind set
	 * @param slots    The maximum amount of triggers
	 * @param triggers    The triggers for the bind set
	 */
	protected BindSet(Type type, int slots, int... triggers) {
		this.type = type;
		this.slots = slots;
		this.triggers = new int[Math.min(slots, triggers.length)];
		System.arraycopy(triggers, 0, this.triggers, 0, slots);
	}

	@Override
	public abstract float getData();

	@Override
	public abstract boolean isDown();

	@Override
	public abstract boolean isJustPressed();

	/**
	 * Clear the triggers
	 */
	public void clear() {
		//TODO: maybe remove this
		triggers = null;
	}

	/**
	 * Replace triggers with completely new triggers
	 */
	public void setTriggers(int... triggers) {
		this.triggers = triggers;
	}
	
	/**
	 * Add triggers to the bind set. Any triggers over the maximum will be cut off.
	 */
	public void addTriggers(int... triggers) {
		appendTriggers(triggers);
	}
	
	/**
	 * Append an array of triggers onto the current set of triggers
	 * @param triggers
	 */
	protected void appendTriggers(int[] triggers) {
		if(this.triggers == null) setTriggers(triggers);
		int pos = this.triggers.length;
		resize(Math.min(this.triggers.length + triggers.length, slots));
		System.arraycopy(triggers, 0, this.triggers, pos, Math.min(this.triggers.length, slots));
	}
	
	/**
	 * Resizes array of triggers
	 * @param target size of new array
	 * @return resized array
	 */
	private int[] resize(int size) {
		//TODO: Check this, we can replace ary.getClass().getComponentType() whatever component type an Integer array is
		//We can also probably find a better way to add triggers in one method instead of resize then copy.
		int[] ary = this.triggers;
		int[] newAry = (int[]) ArrayReflection.newInstance(ary.getClass().getComponentType(), size);
		System.arraycopy(ary, 0, newAry, 0, Math.min(size, newAry.length));
		this.triggers = newAry;
		return newAry;
	}


}
