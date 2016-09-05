/** 
 * Copyright (c) 2016, Peter Vu. All rights reserved.
 * License terms are in the included LICENSE.txt file.
 */
package net.mmbdy.blossom.theater;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.PixmapIO;
import com.badlogic.gdx.utils.ScreenUtils;

import net.mmbdy.blossom.util.Disposable;

//TODO: Document this

public class ScreenshotFactory implements Disposable {

	private static boolean YDOWN = true;

	private static List<Pixmap> screenshots = new ArrayList<Pixmap>();

	private static int counter = 1;

	public static void saveScreenshot() {
		
		try {
			FileHandle fh;
			do {
				fh = new FileHandle("screenshot" + counter++ + ".png");
			} while (fh.exists());
			Pixmap pixmap = getScreenshot(0, 0, Gdx.graphics.getWidth(),
					Gdx.graphics.getHeight(), YDOWN);
			PixmapIO.writePNG(fh, pixmap);
			pixmap.dispose();
			System.out.println("Screenshot Saved.   " + fh.file().getAbsolutePath());
		} catch (Exception e) {
			System.err.println("Unable to save screenshot");
			e.printStackTrace();
		}
	}

	public static void capture() {
		screenshots.add(getScreenshot(0, 0, Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight(), YDOWN));
	}

	public static void saveScreenshots() {
		for (int i = 0; i < screenshots.size(); i++) {
			try {
				FileHandle fh;
				do {
					fh = new FileHandle("screenshot" + counter++ + ".png");
				} while (fh.exists());
				Pixmap pixmap = screenshots.get(i);
				PixmapIO.writePNG(fh, pixmap);
				pixmap.dispose();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		screenshots.clear();
	}

	public static List<Pixmap> getScreenshots() {
		return screenshots;
	}

	private static Pixmap getScreenshot(int x, int y, int w, int h,
			boolean yDown) {
		final Pixmap pixmap = ScreenUtils.getFrameBufferPixmap(x, y, w, h);

		if (yDown) {
			// Flip the pixmap upside down
			ByteBuffer pixels = pixmap.getPixels();
			int numBytes = w * h * 4;
			byte[] lines = new byte[numBytes];
			int numBytesPerLine = w * 4;
			for (int i = 0; i < h; i++) {
				pixels.position((h - i - 1) * numBytesPerLine);
				pixels.get(lines, i * numBytesPerLine, numBytesPerLine);
			}
			pixels.clear();
			pixels.put(lines);
		}
		return pixmap;
	}

	@Override
	public void dispose() {
		for(int i = 0; i < screenshots.size(); i++) {
			screenshots.get(i).dispose();
		}
		screenshots.clear();
	}

}
