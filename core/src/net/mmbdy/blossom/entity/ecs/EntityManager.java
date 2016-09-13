/** 
 * Copyright (c) 2016, Peter Vu. All rights reserved.
 * License terms are in the included LICENSE.txt file.
 */
package net.mmbdy.blossom.entity.ecs;

import com.badlogic.gdx.utils.Pool;

import net.mmbdy.blossom.util.Bag;

/**
 * Manages entities within the entity component system.
 * @author Peter Vu
 *
 */
public class EntityManager {
	//TODOC: Document

	/**
	 * Bag of all entities in the manager
	 */
	private final Bag<Entity> entities;
	//TODO: replace with EntityPool for specific entity stuff
	//Maybe just have an int pool
	private final Pool<Entity> pool = new Pool<Entity>() {
		@Override
		protected Entity newObject() {
			return new Entity(nextId++, world);
		}
	};
	private int nextId;
	private EntityWorld world;

	protected EntityManager(int initialSize) {
		entities = new Bag<Entity>(initialSize);
	}

	public void clear() {
		pool.clear();
		entities.clear();
		
		nextId = 0;
	}

	//ObtainEntity will 
	private Entity obtainEntity() {
		Entity entity = pool.obtain();
		int id = entity.getId();
		if(id >= entities.getCapacity()) entities.ensureCapacity(id);
		entities.set(id, entity);
		return entity;
	}
	
	public void free(Entity entity) {
		free(entity.getId());
	}

	private void free(int entityId) {
		pool.free(entities.remove(entityId));
	}
}
