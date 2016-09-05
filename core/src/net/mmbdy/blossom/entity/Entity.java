package net.mmbdy.blossom.entity;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import net.mmbdy.blossom.physics.spatial.Boundary;

public abstract class Entity {

	public float x, y;

	private boolean removed = false;

	public Entity() {
	}
	
	public void init(){
	}

	public abstract void tick(float delta);
	
	public abstract void render(SpriteBatch batch);
	
	public abstract void dispose();

	public boolean isRemoved() {
		return removed;
	}
	
	public void remove() {
		removed = true;
	}

	/**
	 * @return
	 */
	public Boundary getBounds() {
		// TODO Implement this
		return null;
	}
	
}
