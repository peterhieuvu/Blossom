/** 
 * Copyright (c) 2016, Peter Vu. All rights reserved.
 * License terms are in the included LICENSE.txt file.
 */
package net.mmbdy.blossom.entity.ecs;

/**
 * @author Peter Vu
 *
 */
public enum Component {
	NONE(0);
	
	private int val;
	
	private Component(int val) {
		this.val = val;
	}
}
