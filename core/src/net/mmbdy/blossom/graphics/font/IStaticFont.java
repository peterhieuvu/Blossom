/** 
 * Copyright (c) 2016, Peter Vu. All rights reserved.
 * License terms are in the included LICENSE.txt file.
 */
package net.mmbdy.blossom.graphics.font;

import net.mmbdy.blossom.util.Disposable;

/**
 * Interface for a Static Font.<br \>
 * A static Font is created and keeps texture data onto the Graphics card by use of a SpriteCache. 
 * New data is transferred to the GPU only on creation and modification of the font.
 * @author Peter Vu
 *
 */
public interface IStaticFont extends Disposable {
	
	/**
	 * Called to render the static font
	 */
	public void render();
	
}
