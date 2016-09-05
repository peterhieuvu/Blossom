/** 
 * Copyright (c) 2016, Peter Vu. All rights reserved.
 * License terms are in the included LICENSE.txt file.
 */
package net.mmbdy.blossom;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import net.mmbdy.blossom.gamestate.StateManager;
import net.mmbdy.blossom.input.IInputContext;
import net.mmbdy.blossom.input.gdx.GdxInputContext;
import net.mmbdy.blossom.level.TestLevel;

/**
 * @author Peter Vu
 *
 */
public class Blossom extends ApplicationAdapter {
	
	public static IInputContext input;

	private SpriteBatch batch;
	private float delta;
	
	private StateManager manager;

	@Override
	public void create() {
		input = new GdxInputContext();
		manager = new StateManager(new TestLevel());
		batch = new SpriteBatch();
	}

	@Override
	public void render() {
		// GL
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		//Tick
		delta = Gdx.graphics.getDeltaTime();
		manager.tick(delta);
		
		//Render
		manager.render(batch);
	}
	
	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}
	
	@Override
	public void pause() {
		manager.pause();
		super.pause();
	}

	@Override
	public void resume() {
		manager.resume();
		super.resume();
	}

	@Override
	public void dispose() {
		batch.dispose();
		manager.dispose();
	}
}
