/** 
 * Copyright (c) 2016, Peter Vu. All rights reserved.
 * License terms are in the included LICENSE.txt file.
 */
package net.mmbdy.blossom;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import net.mmbdy.blossom.input.IInputContext;
import net.mmbdy.blossom.input.Input.Binds;
import net.mmbdy.blossom.input.gdx.GdxInputContext;

/**
 * @author Peter Vu
 *
 */
public class Blossom extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;

	public static IInputContext input;

	@Override
	public void create() {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		
		input = new GdxInputContext();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		System.out.format("U: %f  D: %f  L: %f  R: %f  <: %f  >: %f  |: %f  }: %f  {: %f%n",
				Binds.up.getData(), Binds.down.getData(), Binds.left.getData(),
				Binds.right.getData(), Binds.primaryFire.getData(), Binds.secondaryFire.getData(),
				Binds.spot.getData(), Binds.abilityOne.getData(), Binds.abilityTwo.getData());

		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
		img.dispose();
	}
}
