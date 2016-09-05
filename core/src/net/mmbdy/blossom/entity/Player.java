package net.mmbdy.blossom.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import net.mmbdy.blossom.input.Input.Binds;

public class Player extends Mob {
	
	private float speed = 180; // Per second
	
	public Player(float x, float y, TextureRegion texture) {
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