package net.mmbdy.blossom.entity;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class Mob extends Entity {
	
	protected TextureRegion sprite;
	
	protected Mob(float x, float y, TextureRegion sprite) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
	}
	
	public void move(float dx, float dy) {
		x += dx;
		y += dy;
	}
	
}
