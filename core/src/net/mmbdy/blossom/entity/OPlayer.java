/** 
 * Copyright (c) 2016, Peter Vu. All rights reserved.
 * License terms are in the included LICENSE.txt file.
 */
package net.mmbdy.blossom.entity;

//TODOC: Document this

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import net.mmbdy.blossom.input.Input.Binds;

public class OPlayer extends OMob {
	
	private float speed = 180; // Per second
	
	public OPlayer(float x, float y, TextureRegion texture) {
		super(x, y, texture);
	}
	
	@Override
	public void tick(float delta) {
		float boost = 1 + Binds.boost.getData();
		float dx = 0;
		float dy = 0;
		dy -= Binds.up.getData() * speed * boost * delta;
		dy += Binds.down.getData() * speed * boost * delta;
		dx -= Binds.left.getData() * speed * boost * delta;
		dx += Binds.right.getData() * speed * boost * delta;
		move(dx, dy);
	}
	
	@Override
	public void render(SpriteBatch batch) {
		batch.draw(sprite, x, y, 64, 64);
	}
	
	@Override
	public void dispose() {
	}
}