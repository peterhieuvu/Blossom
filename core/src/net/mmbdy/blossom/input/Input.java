/** 
 * Copyright (c) 2016, Peter Vu. All rights reserved.
 * License terms are in the included LICENSE.txt file.
 */
package net.mmbdy.blossom.input;

import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;

import net.mmbdy.blossom.input.ITrigger.Type;

/**
 * Use to poll User input data based on control bindings
 * 
 * @author Peter Vu
 *
 */
public class Input {
	
	public static class Binds {
		
		public static Bind left = new Bind("Left", new KeyBind(Type.Keyboard, 2, Keys.A, Keys.LEFT));
		public static Bind right = new Bind("Right", new KeyBind(Type.Keyboard, 2, Keys.D, Keys.RIGHT));
		public static Bind up = new Bind("Up", new KeyBind(Type.Keyboard, 2, Keys.W, Keys.UP));
		public static Bind down = new Bind("Down", new KeyBind(Type.Keyboard, 2, Keys.S, Keys.DOWN));
		
		public static Bind primaryFire = new Bind("Primary Fire", new ButtonBind(Type.Mouse, 1, Buttons.LEFT));
		public static Bind secondaryFire = new Bind("Secondary Fire", new ButtonBind(Type.Mouse, 1, Buttons.RIGHT));
		public static Bind spot = new Bind("Spot", new ButtonBind(Type.Mouse, 1, Buttons.MIDDLE));
		public static Bind abilityOne = new Bind("Ability 1", new ButtonBind(Type.Mouse, 1, Buttons.FORWARD));
		public static Bind abilityTwo = new Bind("Ability 2", new ButtonBind(Type.Mouse, 1, Buttons.BACK));
		
	}
	
	//TODO: Implement own Input API, abstract between platforms

}
