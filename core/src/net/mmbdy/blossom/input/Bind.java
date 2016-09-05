/** 
 * Copyright (c) 2016, Peter Vu. All rights reserved.
 * License terms are in the included LICENSE.txt file.
 */
package net.mmbdy.blossom.input;

import com.badlogic.gdx.utils.reflect.ArrayReflection;

/**
 * Holds activation data for a single control bind
 * 
 * @author Peter Vu
 *
 */
public class Bind {

	/**
	 * Name of the bind
	 */
	private String name;

	/**
	 * The sets of binds associated with a specific control bind
	 */
	private ITrigger[] binds;

	/**
	 * 
	 * @param name
	 * 		The name of the bind
	 */
	public Bind(String name, ITrigger... binds) {
		this.name = name;
		this.binds = binds;
	}

	public float getData() {
		if (binds == null) return 0;
		//TODO: Check if I need to move the float stand in somewhere else, also check to see if I can not have to do this recursively because the recursion means more instantiation
		//TODO: Always order axis last so that we always check keys before the more expensive axis
		for (int i = 0; i < binds.length; i++) {
			float t = binds[i].getData();
			if (t != 0) return t;
		}
		return 0;
	}

	public boolean isDown() {
		if (binds == null) return false;
		for (int i = 0; i < binds.length; i++) {
			if (binds[i].isDown()) return true;
		}
		return false;
	}

	public boolean isJustPressed() {
		if (binds == null) return false;
		for (int i = 0; i < binds.length; i++) {
			if (binds[i].isJustPressed()) return true;
		}
		return false;
	}

	/**
	 * @return the binds
	 */
	public ITrigger[] getBinds() {
		return binds;
	}

	/**
	 * @param binds the binds to set
	 */
	public void setBinds(ITrigger... binds) {
		this.binds = binds;
	}

	/**
	 * Clear bind set
	 */
	public void clear() {
		binds = null;
	}

	/**
	 * Add new bind sets to existing bind
	 */
	public void addBind(ITrigger... binds) {
		if(this.binds == null) setBinds(binds);
		int pos = this.binds.length;
		resize(this.binds.length + binds.length);
		System.arraycopy(binds, 0, this.binds, pos, this.binds.length);
	}
	
	/**
	 * Resizes array of triggers
	 * @param target size of new array
	 * @return resized array
	 */
	private ITrigger[] resize(int size) {
		//TODO: Check this, we can replace ary.getClass().getComponentType() whatever component type an Integer array is
		ITrigger[] ary = this.binds;
		ITrigger[] newAry = (ITrigger[]) ArrayReflection.newInstance(ary.getClass().getComponentType(), size);
		System.arraycopy(ary, 0, newAry, 0, Math.min(size, newAry.length));
		this.binds = newAry;
		return newAry;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

}
