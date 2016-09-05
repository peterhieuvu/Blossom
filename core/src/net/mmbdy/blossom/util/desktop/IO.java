package net.mmbdy.blossom.util.desktop;

// CodeChef

class IOUtils {

	public static int[] readIntArray(InputReader in, int size) {
		int[] array = new int[size];

		for (int i = 0; i < size; i++) {
			array[i] = in.readInt();
		}
		return array;

	}

}