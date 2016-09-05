package net.mmbdy.blossom.map;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class Map {
	
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
	
	public void dispose() {
		map.dispose();
		renderer.dispose();
	}

}
