/** 
 * Copyright (c) 2016, Peter Vu. All rights reserved.
 * License terms are in the included LICENSE.txt file.
 */
package net.mmbdy.blossom.gamestate;

import java.util.ArrayDeque;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

//TODOC: Fully document this

public class StateManager {
	
	private ArrayDeque<GameState> states = new ArrayDeque<GameState>();
	
	private GameState back;
	
	private boolean suspend = false;
	
	
	public StateManager(GameState... states){
		if(states.length == 0) suspend = true;
		for(GameState state : states){
			pushState(state);
		}
		init();
	}

	public void init() {
		
	}
	
	/**
	 * Replace current gamestate with specified gamestate.
	 */
	public void swapState(GameState state) {
		if(!states.isEmpty()) {
			back.dispose();
			states.removeLast();
		}
		states.addLast(state);
		back = state;
		back.init();
	}
	
	/**
	 * Destroy all states and replace with specified state
	 */
	public void resetStates(GameState state) {
		dispose();
		pushState(state);
	}
	
	public void pushState(GameState state) {
		if(suspend) suspend = true;
		if(!states.isEmpty()) {
			back.pause();
		}
		states.addLast(state);
		back = state;
		back.init();
	}
	
	/**
	 * Destroy current state and resume latest state if available
	 */
	public void popState() {
		if(!states.isEmpty()) {
			back.dispose();
			states.removeLast();
		}
		if(!states.isEmpty()) {
			back = states.peekLast();
			back.resume();
		} else suspend = true;
	}
	
	public void tick(float delta) {
		if(!suspend) back.tick(delta);
	}
	
	public void render(SpriteBatch batch) {
		if(!suspend) back.render(batch);
	}
	
	public void pause() {
		suspend = true;
		back.pause();
	}
	
	public void resume() {
		suspend = false;
		back.resume();
	}
	
	public void dispose() {
		for(GameState state : states) {
			state.dispose();
		}
		//back.dispose();
		states.clear();
	}
	
}
