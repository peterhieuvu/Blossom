/** 
 * Copyright (c) 2016, Peter Vu. All rights reserved.
 * License terms are in the included LICENSE.txt file.
 */
package net.mmbdy.blossom.level;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import net.mmbdy.blossom.entity.Entity;
import net.mmbdy.blossom.entity.Player;
import net.mmbdy.blossom.gamestate.GameState;
import net.mmbdy.blossom.physics.spatial.Boundary;

//TODOC: Document this
//TODO: finish

public abstract class Level implements GameState {
	
	protected Deque<Entity> eQueue = new ArrayDeque<Entity>();
	
	protected List<Entity> entities = new ArrayList<Entity>();
	
	private TextureAtlas playerAtlas;
	private Player player;
	
	public float width = 800, height = 480;
	
	private OrthographicCamera camera;
	
	private Boundary bounds;
	
	@Override
	public void init() {
		camera = new OrthographicCamera();
		camera.setToOrtho(true, 800, 480);
		
		playerAtlas = new TextureAtlas("players.pack");
		
		bounds = new Boundary().setBounds(0, 0, 800, 480);
		
		player = new Player(0, 0, playerAtlas.findRegion("blackblue"));
	}
	
	@Override
	public void tick(float delta) {
		player.tick(delta);
		for (Entity e : entities) {
			e.tick(delta);
		}
		purge();
		while(!eQueue.isEmpty()){
			insert(eQueue.poll());
		}
	}
	
	@Override
	public void render(SpriteBatch batch) {
		batch.setProjectionMatrix(camera.combined);

		// Render Map
		batch.disableBlending();
		batch.begin();
		//draw background
		batch.end();
		
		// Render Objects
		batch.enableBlending();
		batch.begin();
		player.render(batch);
		for (Entity e : entities) {
			e.render(batch);
		}
		
		// Render Overlay (Maybe render this in player)
		batch.end();
	}
	
	@Override
	public void pause() {
	}
	
	@Override
	public void resume() {
	}
	
	@Override
	public void dispose() {
		playerAtlas.dispose();
		player.dispose();
		for (Entity e : entities) {
			e.dispose();
		}
		entities.clear();
		eQueue.clear();
	}
	
	public List<Entity> getEntities() {
		return entities;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void purge() {
		for (int i = 0; i < entities.size(); i++) {
			if (entities.get(i).isRemoved()) entities.remove(i);
		}
	}
	
	public void add(Entity e) {
		eQueue.offer(e);
	}
	
	private void insert(Entity e) {
		e.init(this);
		entities.add(e);
	}
	
	public Boundary getBounds() {
		return bounds;
	}
	
}