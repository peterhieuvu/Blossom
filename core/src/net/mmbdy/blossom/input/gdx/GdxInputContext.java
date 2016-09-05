/** 
 * Copyright (c) 2016, Peter Vu. All rights reserved.
 * License terms are in the included LICENSE.txt file.
 */
package net.mmbdy.blossom.input.gdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

import net.mmbdy.blossom.input.IInputContext;

/**
 * @author Peter Vu
 *
 */
public class GdxInputContext implements IInputContext {

	private Input input = Gdx.input;
	
	/**
	 * 
	 */
	public GdxInputContext() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public float getX() {
		return input.getX();
	}

	@Override
	public float getY() {
		return input.getY();
	}

	@Override
	public float getDeltaX() {
		return input.getDeltaX();
	}

	@Override
	public float getDeltaY() {
		return input.getDeltaY();
	}

	@Override
	public float getPixX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getPixY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getDeltaPixX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getDeltaPixY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isButtonPressed(int code) {
		return input.isButtonPressed(code);
	}

	@Override
	public boolean isButtonJustPressed(int code) {
		return false;
	}

	@Override
	public boolean isKeyPressed(int code) {
		return input.isKeyPressed(code);
	}

	@Override
	public boolean isKeyJustPressed(int code) {
		return input.isKeyJustPressed(code);
	}

	@Override
	public boolean isKeyTyped(int code) {
		return false;
	}

	@Override
	public void setInputProcessor(InputProcessor processor) {
		input.setInputProcessor(processor);
	}

}
