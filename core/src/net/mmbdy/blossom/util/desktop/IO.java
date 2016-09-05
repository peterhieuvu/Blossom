/** 
 * Copyright (c) 2016, Peter Vu. All rights reserved.
 * License terms are in the included LICENSE.txt file.
 */
package net.mmbdy.blossom.util.desktop;

// CodeChef
// TODO: Document this

class IOUtils {

	public static int[] readIntArray(InputReader in, int size) {
		int[] array = new int[size];

		for (int i = 0; i < size; i++) {
			array[i] = in.readInt();
		}
		return array;

	}

}