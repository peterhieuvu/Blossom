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

import net.mmbdy.blossom.entity.OEntity;
import net.mmbdy.blossom.entity.OPlayer;
import net.mmbdy.blossom.gamestate.GameState;
import net.mmbdy.blossom.physics.spatial.Boundary;

//TODOC: Document this
//TODO: finish

public abstract class Level implements GameState {
	
	protected Deque<OEntity> eQueue = new ArrayDeque<OEntity>();
	
	protected List<OEntity> entities = new ArrayList<OEntity>();
	
	private TextureAtlas playerAtlas;
	private OPlayer player;
	
	public float width = 800, height = 480;
	
	private OrthographicCamera camera;
	
	private Boundary bounds;
	
	@Override
	public void init() {
		camera = new OrthographicCamera();
		camera.setToOrtho(true, 800, 480);
		
		playerAtlas = new TextureAtlas("players.pack");
		
		bounds = new Boundary().setBounds(0, 0, 800, 480);
		
		player = new OPlayer(0, 0, playerAtlas.findRegion("blackblue"));
	}
	
	@Override
	public void tick(float delta) {
		player.tick(delta);
		for (OEntity e : entities) {
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
		for (OEntity e : entities) {
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
		for (OEntity e : entities) {
			e.dispose();
		}
		entities.clear();
		eQueue.clear();
	}
	
	public List<OEntity> getEntities() {
		return entities;
	}
	
	public OPlayer getPlayer() {
		return player;
	}
	
	public void purge() {
		for (int i = 0; i < entities.size(); i++) {
			if (entities.get(i).isRemoved()) entities.remove(i);
		}
	}
	
	public void add(OEntity e) {
		eQueue.offer(e);
	}
	
	private void insert(OEntity e) {
		e.init(this);
		entities.add(e);
	}
	
	public Boundary getBounds() {
		return bounds;
	}
	
}