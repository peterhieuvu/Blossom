/** 
 * Copyright (c) 2016, Peter Vu. All rights reserved.
 * License terms are in the included LICENSE.txt file.
 */
package net.mmbdy.blossom.util;

/**
 * Interface to dispose resources
 * @author Peter Vu
 *
 */
public interface Disposable {
	
	/**
	 * Releases all the resources of the object
	 */
	public void dispose();

}
