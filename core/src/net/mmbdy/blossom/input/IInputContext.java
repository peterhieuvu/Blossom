/** 
 * Copyright (c) 2016, Peter Vu. All rights reserved.
 * License terms are in the included LICENSE.txt file.
 */
package net.mmbdy.blossom.input;

import com.badlogic.gdx.InputProcessor;

/**
 * Implementation of higher level Input Functions
 * @author Peter Vu
 *
 */
public interface IInputContext {

	// Mouse
	
	/**
	 * Get the horizontal position of the mouse cursor in screen space
	 */
	public float getX();
	
	/**
	 * Get the vertical position of the mouse cursor in screen space
	 */
	public float getY();
	
	/**
	 * Get the horizontal position change of the mouse in screen space since the last update
	 */
	public float getDeltaX();
	
	/**
	 * Get the vertical position change of the mouse in screen space since the last update
	 */
	public float getDeltaY();
	
	/**
	 * Get the horizontal position of the mouse cursor in pixels
	 */
	public float getPixX();
	
	/**
	 * Get the vertical position of the mouse cursor in pixels
	 */
	public float getPixY();
	
	/**
	 * Get the horizontal position change of the mouse in pixels since the last update
	 */
	public float getDeltaPixX();
	
	/**
	 * Get the vertical position change of the mouse in pixels since the last update
	 */
	public float getDeltaPixY();
	
	// Mouse Buttons
	
	/**
	 * 
	 * @return Whether or not the specified button is pressed
	 * @param The code of the desired button
	 */
	public boolean isButtonPressed(int code);
	
	/**
	 * 
	 * @return Whether or not the specified button was just presseed
	 * @param The code of the desired button
	 */
	public boolean isButtonJustPressed(int code);
	
//	public boolean isButtonTyped();

	// Keyboard
	
	/**
	 * 
	 * @return Whether or not the specified key is pressed
	 * @param The code of the desired key
	 */
	public boolean isKeyPressed(int code);
	
	/**
	 * 
	 * @return Whether or not the specified key was just pressed
	 * @param The code of the desired key
	 */
	public boolean isKeyJustPressed(int code);
	
	/**
	 * 
	 * @return Whether or not the specified key should be active when held down
	 * @param The code of the desired key
	 */
	public boolean isKeyTyped(int code);
	
	// Event System

	//TODO: My Input Processor
	/**
	 * Unfinished, defaulted at LibGDX input processor
	 */
	public void setInputProcessor(InputProcessor processor);
}
