/** 
 * Copyright (c) 2016, Peter Vu. All rights reserved.
 * License terms are in the included LICENSE.txt file.
 */
package net.mmbdy.blossom.gamestate;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import net.mmbdy.blossom.util.Disposable;

//TODOC: Document this

public interface GameState extends Disposable {

	//Create and destroy
	
	public void init();

	//Managing transitions and pauses
	
	public void pause();
	
	public void resume();
	
	//Essentials
	
	public void tick(float delta);
	
	public void render(SpriteBatch batch);
	
}
