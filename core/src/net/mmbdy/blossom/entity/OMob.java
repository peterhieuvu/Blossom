/** 
 * Copyright (c) 2016, Peter Vu. All rights reserved.
 * License terms are in the included LICENSE.txt file.
 */
package net.mmbdy.blossom.entity;

//TODOC: Document this

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class OMob extends OEntity {
	
	protected TextureRegion sprite;
	
	protected OMob(float x, float y, TextureRegion sprite) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
	}
	
	public void move(float dx, float dy) {
		x += dx;
		y += dy;
	}
	
}
