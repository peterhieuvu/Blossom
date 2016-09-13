/** 
 * Copyright (c) 2016, Peter Vu. All rights reserved.
 * License terms are in the included LICENSE.txt file.
 */
package net.mmbdy.blossom.entity.ecs;

import com.badlogic.gdx.utils.Pool.Poolable;

/**
 * An entity within the entity component system. Entities are a container for {@link IComponent} and are acted upon by {@link EntitySystem}.
 * Entities are represented by an int, however the Entity class is supported for easy access to linked components
 * @author Peter Vu
 *
 */
public class Entity implements Poolable {
	
	//TODOC: Document
	
	private EntityWorld world;
	
	public boolean alive;
	
	private int id;
	
	protected Entity(int id, EntityWorld world) {
		this.id = id;
		this.world = world;
		alive = false;
	}
	
	public void init() {
		if(alive) throw new IllegalStateException("Cannot initialize a live Entity!");
		alive = true;
	}
	
	public int getId() {
		return id;
	}
	
	public boolean equals(Entity entity) {
		return (entity != null && entity.id == id);
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o==null | getClass() != o.getClass()) return false;
		
		Entity entity = (Entity) o;
		
		return id == entity.id;
	}
	
	@Override
	public String toString() {
		return "Entity[" + id + "]";
	}

	@Override
	public void reset() {
		alive = false;
		id = 0;
	}
}
