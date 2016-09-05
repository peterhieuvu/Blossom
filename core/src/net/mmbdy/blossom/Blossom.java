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
 * Base class for the Blossom Game engine. A core class that will be called from all Launchers regardless of platform
 * @author Peter Vu
 */
public class Blossom extends ApplicationAdapter /* implements Disposable */ {
	
	/**
	 * Input class which has references to all Control Bindings. Static class that can be called from anywhere.
	 */
	public static IInputContext input;

	/**
	 * Main sprite batch used within the engine.
	 */
	private SpriteBatch batch;
	
	/**
	 * Time in seconds since the last update.
	 */
	private float delta;
	
	/**
	 * The state manager of the game that handles and organizes game states.
	 */
	private StateManager manager;

	/**
	 * Called on creation of the application
	 */
	@Override
	public void create() {
		input = new GdxInputContext();
		manager = new StateManager(new TestLevel());
		batch = new SpriteBatch();
	}

	/**
	 * Called when the application should render itself. If VSync is active, this method will be synchronized with the refresh rate of the User's monitor.
	 */
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
	
	/**
	 * Called whenever the window is resized.
	 * @param width the width of the window in pixels
	 * @param height the height of the window in pixels
	 */
	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}
	
	/**
	 * Called whenever the application is paused. This is usually when the window loses focus and just before the application is destroyed.
	 */
	@Override
	public void pause() {
		manager.pause();
		super.pause();
	}

	/**
	 * Called whenever the application is resumed. This is usually when the window regains focus.
	 */
	@Override
	public void resume() {
		manager.resume();
		super.resume();
	}

	/**
	 * Called when the application is destroyed. It is preceded by a call to {@link #pause()}.
	 */
	@Override
	public void dispose() {
		batch.dispose();
		manager.dispose();
	}
}
