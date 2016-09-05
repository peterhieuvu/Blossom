/** 
 * Copyright (c) 2016, Peter Vu. All rights reserved.
 * License terms are in the included LICENSE.txt file.
 */
package net.mmbdy.blossom;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import net.mmbdy.blossom.entity.Player;
import net.mmbdy.blossom.input.IInputContext;
import net.mmbdy.blossom.input.Input.Binds;
import net.mmbdy.blossom.input.gdx.GdxInputContext;

/**
 * @author Peter Vu
 *
 */
public class Blossom extends ApplicationAdapter {
	
	private SpriteBatch batch;
	private float delta;
	
	private Player player;
	private TextureAtlas playerAtlas;
	
	private OrthographicCamera camera;
	
	public static IInputContext input;

	@Override
	public void create() {
		batch = new SpriteBatch();
		input = new GdxInputContext();
		
		camera = new OrthographicCamera();
		camera.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		playerAtlas = new TextureAtlas("players.pack");
		
		player = new Player(0, 0, playerAtlas.findRegion("blackblue"));
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		System.out.format("U: %f  D: %f  L: %f  R: %f  B: %f%n", Binds.up.getData(),
				Binds.down.getData(), Binds.left.getData(), Binds.right.getData(),
				Binds.boost.getData());

		delta = Gdx.graphics.getDeltaTime();
		
		player.tick(delta);
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		player.render(batch);
		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
		player.dispose();
		playerAtlas.dispose();
	}
}
