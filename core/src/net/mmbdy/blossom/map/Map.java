/** 
 * Copyright (c) 2016, Peter Vu. All rights reserved.
 * License terms are in the included LICENSE.txt file.
 */
package net.mmbdy.blossom.map;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import net.mmbdy.blossom.util.Disposable;

//TODO: Document this

public class Map implements Disposable {
	
	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;
	private OrthographicCamera camera;
	
	public Map(TiledMap map, OrthographicCamera camera, float unitScale) {
		this.map = map;
		this.camera = camera;
		
		renderer = new OrthogonalTiledMapRenderer(map, unitScale);
	}
	
	public Map(TiledMap map, OrthographicCamera camera) {
		this.map = map;
		this.camera = camera;
		
		renderer = new OrthogonalTiledMapRenderer(map);
	}
	
	public void render() {
		renderer.setView(camera);
		renderer.render();
	}
	
	@Override
	public void dispose() {
		map.dispose();
		renderer.dispose();
	}

}
