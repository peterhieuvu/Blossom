/** 
 * Copyright (c) 2016, Peter Vu. All rights reserved.
 * License terms are in the included LICENSE.txt file.
 */
package net.mmbdy.blossom.input;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

//TODO: Document this

public class EventInputProcessor implements InputProcessor {

	public class Bind {

		public final int[] keys;
		public int presses, absorbs;
		public boolean down, clicked;

		public Bind(Binds bind, int... keys) {
			this.keys = keys;
			binds.put(bind, this);
		}

		public boolean isJustPressed() {
			for (int i = 0; i < keys.length; i++) {
				if (Gdx.input.isKeyJustPressed(keys[i])) return true;
			}
			return false;
		}

		public void update() {
			boolean pressed = false;
			for (int i = 0; i < keys.length; i++) {
				pressed = EventInputProcessor.keys[keys[i]];
			}
			if (pressed != down) down = pressed;
			if (pressed) presses++;
			if (absorbs < presses) {
				absorbs++;
				clicked = true;
			} else {
				clicked = false;
			}
		}
	}

	public enum Binds {

	}

	private static boolean[] keys = new boolean[256];
	private static int scroll, x, y;

	public static boolean up, down, left, right;

	private Map<Binds, Bind> binds = new HashMap<EventInputProcessor.Binds, EventInputProcessor.Bind>();

	public EventInputProcessor() {
		Gdx.input.setInputProcessor(this);
	}

	public void tick() {
		for (Bind bind : binds.values()) {
			bind.update();
		}
	}

	public void reset() {
		for (Bind bind : binds.values()) {
			bind.down = false;
		}
	}

	//STATIC INPUT METHODS

	//MOUSE
	public static int getX() {
		return x;
	}

	public static int getY() {
		return y;
	}

	public static int getScroll() {
		return scroll;
	}

	//KEYBOARD
	public boolean isDown(Binds bind) {
		return binds.get(bind).down;
	}

	public boolean isClicked(Binds bind) {
		return binds.get(bind).clicked;
	}

	public boolean isJustPressed(Binds bind) {
		return binds.get(bind).isJustPressed();
	}

	//END

	@Override
	public boolean keyDown(int keycode) {
		keys[keycode] = true;
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		keys[keycode] = false;
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		x = screenX;
		y = screenY;
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		scroll = amount;
		return false;
	}

}
