package net.mmbdy.blossom.gamestate;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface GameState {

	//Create and destroy
	
	public void init();
	
	public void dispose();

	//Managing transitions and pauses
	
	public void pause();
	
	public void resume();
	
	//Essentials
	
	public void tick(float delta);
	
	public void render(SpriteBatch batch);
	
}
